package homework.v3.entityext;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.List;

public class BundleExt implements Externalizable {
    
    public static final long SerialVersionUID = 1L;
    
    private List<PathExt> path;
    private List<String> values;

    public List<PathExt> getPath() {
        return path;
    }
    public void setPath(List<PathExt> path) {
        this.path = path;
    }

    public List<String> getValues() {
        return values;
    }
    public void setValues(List<String> values) {
        this.values = values;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.getPath());
        out.writeObject(this.getValues());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.setPath((List<PathExt>)in.readObject());
        this.setValues((List<String>)in.readObject());
    }
}
