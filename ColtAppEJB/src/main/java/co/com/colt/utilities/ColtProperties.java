/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.colt.utilities;

import java.util.ResourceBundle;

/**
 *
 * @author
 */
public class ColtProperties implements IColtProperties {

    private static ResourceBundle names;

    public ColtProperties() {
        names = ResourceBundle.getBundle("co.com.colt.properties.ColtProperties");
    }

    @Override
    public String getString(String propertie) throws ColtException {
        if (propertie == null) {
            throw new ColtException("La deficinicion de la propiedad esta vacia");
        }
        return names.getString(propertie);
    }

}
