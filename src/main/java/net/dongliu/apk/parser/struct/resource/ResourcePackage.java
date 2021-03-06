package net.dongliu.apk.parser.struct.resource;

import net.dongliu.apk.parser.struct.StringPool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Resource packge.
 *
 * @author dongliu
 */
public class ResourcePackage {
    // the packageName
    public String name;
    public short id;
    // contains the names of the types of the Resources defined in the ResourcePackage
    public StringPool typeStringPool;
    //  contains the names (keys) of the Resources defined in the ResourcePackage.
    public StringPool keyStringPool;

    public ResourcePackage(PackageHeader header) {
        this.name = header.name;
        this.id = (short) header.id;
    }

    private Map<Short, TypeSpec> typeSpecMap = new HashMap<Short, TypeSpec>();

    private Map<Short, List<Type>> typesMap = new HashMap<Short, List<Type>>();

    public void addTypeSpec(TypeSpec typeSpec) {
        this.typeSpecMap.put(typeSpec.id, typeSpec);
    }

    public TypeSpec getTypeSpec(Short id) {
        return this.typeSpecMap.get(id);
    }

    public void addType(Type type) {
        List<Type> types = this.typesMap.get(type.id);
        if (types == null) {
            types = new ArrayList<Type>();
            this.typesMap.put(type.id, types);
        }
        types.add(type);
    }

    public List<Type> getTypes(Short id) {
        return this.typesMap.get(id);
    }
}
