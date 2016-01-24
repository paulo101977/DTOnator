/*
 * Copyright (C) 2015 Vinaya Prasad N
 *
 *         This program is free software: you can redistribute it and/or modify
 *         it under the terms of the GNU General Public License as published by
 *         the Free Software Foundation, either version 3 of the License, or
 *         (at your option) any later version.
 *
 *         This program is distributed in the hope that it will be useful,
 *         but WITHOUT ANY WARRANTY; without even the implied warranty of
 *         MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *         GNU General Public License for more details.
 *
 *         You should have received a copy of the GNU General Public License
 *         along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package nvinayshetty.DTOnator.FieldRepresentors;

import nvinayshetty.DTOnator.FieldCreator.AccessModifier;
import nvinayshetty.DTOnator.Utility.DtoHelper;


/**
 * Created by vinay on 12/7/15.
 */
public class JsonArrayRepresentor extends FieldRepresentor {
    private String dataType;

    protected static String getGsonAnnotationFor(String key) {
        return GSON_ANNOTATION_PREFIX + key + ANNOTATION_SUFFIX;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    @Override
    public String getFieldRepresentationFor(AccessModifier accessModifier, String key) {
        return accessModifier.getModifier() + "java.util.List<" + DtoHelper.firstetterToUpperCase(dataType) + ">" + suffix(key);

    }

    public String getGsonFieldRepresentationFor(AccessModifier AccessModifier, String key) {
        return getGsonAnnotationFor(key) + getFieldRepresentationFor(AccessModifier, key);
    }

}
