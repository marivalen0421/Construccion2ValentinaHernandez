package app.adapter.in.validators;

import org.springframework.stereotype.Component;

import app.domain.model.emuns.Species;

@Component
public class PetValidator extends SimpleValidator {
    public String nameValidator(String value) throws Exception{
        return stringValidator("Nombre de la mascota", value);
    }
    public String descriptionValidator(String value) throws Exception{
        return stringValidator("Detalles de la mascota", value);
    }
    public Species spicesValidator(String value) throws Exception{
        stringValidator("Especie de la mascota", value);
        return Species.valueOf(value);
    }

    public String raceValidator(String value) throws Exception{
        return stringValidator("Raza de la mascota", value);
    }
    public double weigthValidator(String value) throws Exception{
        return doubleValidator("Peso de la mascota", value);
    }
    public int ageValidator(String value) throws Exception{
        return integerValidator("Edad de la mascota", value);

    }
    public long idValidator(String value) throws Exception{
        return longValidator("Id de la mascota", value);
    }
}
