package com.unaj.models.controllers;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.AbstractResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.unaj.models.entity.Usuario;
import com.unaj.models.services.IUsuarioService;
import com.unaj.models.services.UsuarioService;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class UsuarioRestController {
	@Autowired
	private IUsuarioService usuarioService;
	
	@GetMapping("/usuarios")
	public List <Usuario> index(){
		return usuarioService.findAll();
	}
	
	@GetMapping("/usuarios/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Usuario show(@PathVariable Long id) {
		return usuarioService.findById(id);
	}
	
	@PostMapping("/usuarios")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario create(@RequestBody Usuario usuario) {
		return usuarioService.save(usuario);
	}
	
	
	@PutMapping("/usuarios/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario update(@RequestBody Usuario usuario,@PathVariable Long id) {
		Usuario usuarioActual = usuarioService.findById(id);
		
		usuario.setNombre(usuario.getNombre());
		usuario.setApellido(usuario.getApellido());
		usuario.setEmail(usuario.getEmail());
		
		return usuarioService.save(usuarioActual);
	}
	
	@DeleteMapping("/usuarios/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		
		Usuario usuario = usuarioService.findById(id);
		
		String nombrefotoAnterior = usuario.getFoto();
		
		if(nombrefotoAnterior !=null  && nombrefotoAnterior.length() >0) {
			Path rutaFotoAnterior = Paths.get("uploads").resolve(nombrefotoAnterior).toAbsolutePath();
			File archivoFotoAnterior = rutaFotoAnterior.toFile();
			if(archivoFotoAnterior.exists() && archivoFotoAnterior.canRead()) {
				archivoFotoAnterior.delete();
			}
			
		}
		
		 usuarioService.delete(id);
	}
	
	@PostMapping("/usuarios/upload")
	public ResponseEntity<?> upload(@RequestParam("archivo") MultipartFile archivo, @RequestParam("id") Long id){
		 
		Map<String,Object> response= new HashMap<>();
		
		Usuario usuario = usuarioService.findById(id);
		
		if(!archivo.isEmpty()) {
			String nombreArchivo =UUID.randomUUID().toString() + "_" + archivo.getOriginalFilename().replace(" ", "");
			Path rutaArchivo = Paths.get("uploads").resolve(nombreArchivo).toAbsolutePath();
			try {
				Files.copy(archivo.getInputStream(), rutaArchivo);
			} catch (IOException e) {
				response.put("mensaje", "Error al subir la imagen " + nombreArchivo);
				response.put("error", e.getMessage().concat(": ").concat(e.getCause().getMessage()));
				return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			String nombrefotoAnterior = usuario.getFoto();
			
			if(nombrefotoAnterior !=null  && nombrefotoAnterior.length() >0) {
				Path rutaFotoAnterior = Paths.get("uploads").resolve(nombrefotoAnterior).toAbsolutePath();
				File archivoFotoAnterior = rutaFotoAnterior.toFile();
				if(archivoFotoAnterior.exists() && archivoFotoAnterior.canRead()) {
					archivoFotoAnterior.delete();
				}
				
			}
			usuario.setFoto(nombreArchivo);
			usuarioService.save(usuario);
			response.put("usuario",usuario);
			response.put("mensaje", "Ha subido correctamente una imagen " + nombreArchivo);
			
		}
		
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
	}
	
	@GetMapping("usuarios/upload/img/{nombreFoto:.+}")
	public ResponseEntity<Resource> verFoto(@PathVariable String nombreFoto) throws MalformedURLException{
		Path rutaArchivo = Paths.get("uploads").resolve(nombreFoto).toAbsolutePath();
		Resource recurso = null;
		
		recurso =  new UrlResource(rutaArchivo.toUri());
		
		if(!recurso.exists()&& recurso.isReadable()) {
			throw new RuntimeException("error no se pudo cargar la imagen"+nombreFoto);
		}
		
		HttpHeaders cabecera = new HttpHeaders();
		cabecera.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\"" );
		
		return new ResponseEntity<Resource>(recurso, cabecera, HttpStatus.OK);
		
		
	}

}
