package com.example.pid_2025.controlleur;
import com.example.pid_2025.dal.ArtistRepository;
import com.example.pid_2025.entities.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/artist")
public class ArtistController {

    @Autowired
    ArtistRepository artistRepository;


    @GetMapping("/")
    public List<Artist> getAll(){
        System.out.println( artistRepository.findAll().stream().findFirst());
        return artistRepository.findAll() ;

    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Artist> getByid(@PathVariable Long id ) {
       return ResponseEntity.ok( artistRepository.findById( id ).orElseThrow());
    }

    @GetMapping("/{name}")
    public List<Artist> getByName(@PathVariable String name){
        return artistRepository.findByLastname( name );
    }
    @PostMapping("/add")
    public Artist addArtist (@RequestBody Artist newArtist){
        return artistRepository.save(newArtist);
    }
    @PutMapping("/updatLastName/{id}")
    public Artist updateLastName (@PathVariable Long id , @RequestBody String lastName){

     Artist artist = artistRepository.findById( id ).orElseThrow();
     artist.setLastname( lastName);
    return artistRepository.save(artist) ;
    }

    @PutMapping("/{id}")
    public Artist updateArtiste (@PathVariable Long id , @RequestBody Artist newArtist){

        Artist artist = artistRepository.findById( id ).orElseThrow();
        artist.setFirstname(newArtist.getFirstname());
        artist.setLastname( newArtist.getLastname());
        return artistRepository.save(artist) ;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteArtist( @PathVariable long id ){
        artistRepository.deleteById(id);
    }

    @GetMapping("/helllo")
    public String index(){
        return "hello from rest";
    }
}
