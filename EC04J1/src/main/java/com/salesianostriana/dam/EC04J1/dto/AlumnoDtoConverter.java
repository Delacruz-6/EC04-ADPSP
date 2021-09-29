package com.salesianostriana.dam.EC04J1.dto;


import com.salesianostriana.dam.EC04J1.Alumno;
import org.springframework.stereotype.Component;


@Component
public class AlumnoDtoConverter {

    public Alumno createAlumnoDtoToAlumno(CreateAlumnoDto c){
        return new Alumno(
                c.getNombre(),
                c.getApellido1(),
                c.getApellido2(),
                c.getTelefono(),
                c.getEmail()
        );
    }

    public GetAlumnoDto alumnoToGetAlumnoDto (Alumno a) {

        GetAlumnoDto result = new GetAlumnoDto();
        result.setNombre(a.getNombre());
        result.setApellidos(String.format("%s, %s", a.getApellido1(), a.getApellido2()));
        result.setEmail(a.getEmail());
        result.setCurso(a.getCurso().getNombre());
        result.setDireccion(a.getDireccion().getCp());
        return result;
    }
}
