package homework.v3.entityext;

import org.codehaus.jackson.annotate.JsonGetter;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.List;

public class JsonFileClassExt implements Externalizable {
    
    public static final long SerialVersionUID = 1L;
    
    private String version;
    public List<JsonParametersExt> parameters;

    @Override
    public String toString() {
        return this.version + "\n" + this.parameters;
    }

    public void setVersion(String version) {
        this.version = version;
    }
    @JsonGetter("version")
    public String getVersion() {
        return this.version;
    }
    @JsonGetter("parameters")
    public void setParameters(List<JsonParametersExt> parameters) {
        this.parameters = parameters;
    }
    public List<JsonParametersExt> getParameters() {
        return this.parameters;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.getVersion());
        out.writeObject(this.getParameters());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.setVersion((String)in.readObject());
        this.setParameters((List<JsonParametersExt>)in.readObject());
    }
}
