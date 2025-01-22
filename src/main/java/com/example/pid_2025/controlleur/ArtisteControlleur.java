package com.example.pid_2025.controlleur;

import com.example.pid_2025.dal.ArtisteRepository;
import com.example.pid_2025.entities.Artiste;
import com.example.pid_2025.entities.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artiste")
public class ArtisteControlleur {

    @Autowired
    ArtisteRepository artisteRepository;


    @GetMapping("/")
    public List<Artiste> getAll(){
        System.out.println( artisteRepository.findAll().stream().findFirst());
        return artisteRepository.findAll() ;

    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Artiste> getByid(@PathVariable Long id ) {
       return ResponseEntity.ok( artisteRepository.findById( id ).orElseThrow());
    }

    @GetMapping("/{name}")
    public List<Artiste> getByName( @PathVariable String name){
        return artisteRepository.findArtistesByFirstname( name );
    }
    @PostMapping("/add")
    public Artiste addArtist ( @RequestBody Artiste newArtiste){
        return artisteRepository.save( newArtiste);
    }
    @PutMapping("/updatLastName/{id}")
    public Artiste updateLastName ( @PathVariable Long id ,@RequestBody String lastName){

     Artiste artiste = artisteRepository.findById( id ).orElseThrow();
     artiste.setLastname( lastName);
    return artisteRepository.save( artiste) ;
    }

    @PutMapping("/{id}")
    public Artiste updateArtiste ( @PathVariable Long id ,@RequestBody Artiste newArtiste){

        Artiste artiste = artisteRepository.findById( id ).orElseThrow();
        artiste.setFirstname(newArtiste.getFirstname());
        artiste.setLastname( newArtiste.getLastname());
        return artisteRepository.save( artiste) ;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteArtist( @PathVariable long id ){
        artisteRepository.deleteById(id);
    }

    @GetMapping("/helllo")
    public String index(){
        return "hello from rest";
    }
}
//test