package org.lessons.java;

import org.lessons.java.auth.conf.AuthConf;
import org.lessons.java.auth.db.Role;
import org.lessons.java.auth.db.User;
import org.lessons.java.auth.service.RoleService;
import org.lessons.java.auth.service.UserService;
import org.lessons.java.db.pojo.Categoria;
import org.lessons.java.db.pojo.Foto;
import org.lessons.java.db.service.CategoriaService;
import org.lessons.java.db.service.FotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringIlMioFotoalbumApplication implements CommandLineRunner{

	@Autowired
	private FotoService fotoService;
	
	@Autowired 
	private CategoriaService categoriaService;
	
	@Autowired 
	private RoleService roleService;
	
	@Autowired 
	private UserService userService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringIlMioFotoalbumApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		
		Categoria cat1 = new Categoria("Naturalistica");
		Categoria cat2 = new Categoria("Reportage");
		Categoria cat3 = new Categoria("Viaggio");
		Categoria cat4 = new Categoria("Sportiva");
		
		categoriaService.save(cat1);
		categoriaService.save(cat2);
		categoriaService.save(cat3);
		categoriaService.save(cat4);
		
		fotoService.save(new Foto("Foto Calcio", "Bella foto della partita", "https://picsum.photos/200", true, cat4));
		fotoService.save(new Foto("Foto Naturalistica", "Bella foto della natura", "https://picsum.photos/200", true, cat1));
		fotoService.save(new Foto("Foto Calcio", "Bella foto della partita 2", "https://picsum.photos/200", true, cat4));
		fotoService.save(new Foto("Foto Reportage", "Bella foto del reportage", "https://picsum.photos/200", true, cat2));
		fotoService.save(new Foto("Foto Viaggio", "Bella foto del viaggio", "https://picsum.photos/200", true, cat3));
		fotoService.save(new Foto("Foto Naturalistica", "Bella foto del bosco", "https://picsum.photos/200", true, cat1));
		
		Role roleUser = new Role("USER");
		Role roleAdmin = new Role("ADMIN");
		roleService.save(roleUser);
		roleService.save(roleAdmin);
		
		String pws = AuthConf.passwordEncoder().encode("pws");
		
		User DioUser = new User("DioUser", pws, roleUser);
		User GiuseppeAdmin = new User("GiuseppeAdmin", pws, roleAdmin);
		
		userService.save(DioUser);
		userService.save(GiuseppeAdmin);
	}
}
