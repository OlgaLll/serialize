package homework.v3.entityext;

import org.codehaus.jackson.annotate.JsonPropertyOrder;

import java.io.*;
import java.util.List;

@JsonPropertyOrder({"name", "description", "isList", "roles", "type", "bundle"})
public class JsonParametersExt implements Externalizable {
    
    public static final long SerialVersionUID = 1L;
    
    private String name;
    private String description = "";
    private boolean isList;
    private List<String> roles;
    private String type;
    private List<BundleExt> bundle;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getisList() {
        return isList;
    }

    public void setList(boolean isList) {
        this.isList = isList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<BundleExt> getBundle() {
        return bundle;
    }

    public void setBundle(List<BundleExt> bundle) {
        this.bundle = bundle;
    }

    @Override
    public String toString() {

        String s = "";
        for (String s1: roles){
            s += s1;
        }

        return  name + "\n" +
                description + "\n" +
                isList + "\n" +
                type + "\n" +
                bundle + "\n" +
                s;

    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.getName());
        out.writeObject(this.getDescription());
        out.writeObject(this.getisList());
        out.writeObject(this.getRoles());
        out.writeObject(this.getType());
        out.writeObject(this.getBundle());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.setName((String)in.readObject());
        this.setDescription((String)in.readObject());
        this.setList((boolean)in.readObject());
        this.setRoles((List<String>)in.readObject());
        this.setType((String)in.readObject());
        this.setBundle((List<BundleExt>)in.readObject());
    }
}
