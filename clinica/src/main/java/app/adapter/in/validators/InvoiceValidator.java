package app.adapter.in.validators;

import org.springframework.stereotype.Component;

@Component
public class InvoiceValidator extends SimpleValidator {
    public String productNameValidator(String value) throws Exception{
        return stringValidator("Nombre del producto", value);
    }
    public long petIdValidator(String value) throws Exception{
        return longValidator("Id de la mascota", value);
    }
    public long ownerDocumentValidator(String value) throws Exception{
        return longValidator("Cedula del dueño", value);
    }
    public boolean isMedicineValidator(String value) throws Exception{
        stringValidator("venta de medicina", value);
        return value.equals("si");
    }
    public long orderIdValidator(String value) throws Exception{
        return longValidator("Id de la orden", value);
    }
    public double amountValidator(String value) throws Exception{
        return doubleValidator("Precio de la fac", value);
    }
}
