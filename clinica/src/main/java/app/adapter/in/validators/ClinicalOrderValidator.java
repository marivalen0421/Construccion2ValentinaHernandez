package app.adapter.in.validators;

import org.springframework.stereotype.Component;

@Component
public class ClinicalOrderValidator extends SimpleValidator {
    public String medicineValidator(String value) throws Exception{
        return stringValidator("Medicina de la orden", value);
    }
    public String doceValidator(String value) throws Exception{
        return stringValidator("Dosis de la medicina", value);
    }
}
