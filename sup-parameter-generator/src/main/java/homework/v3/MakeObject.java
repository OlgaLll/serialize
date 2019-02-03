package homework.v3;

import homework.v3.entity.Bundle;
import homework.v3.entity.JsonFileClass;
import homework.v3.entity.JsonParameters;
import homework.v3.entity.Path;

import java.util.ArrayList;
import java.util.List;

public class MakeObject {
    public JsonFileClass makeObject(int n) {
        JsonFileClass jc = new JsonFileClass();
        jc.setVersion("1.0");
        jc.setParameters(makeListJsonParameters(n));
        return jc;
    }

    private List<JsonParameters> makeListJsonParameters(int n) {
        List<JsonParameters> jpl = new ArrayList<>();
        for (int i=0; i<n; i++) {
            jpl.add(makeJsonParameters(i));
        }
        return jpl;
    }

    private JsonParameters makeJsonParameters(int i) {
        JsonParameters jp = new JsonParameters();
        jp.setType("type"+i);
        jp.setName("name"+i);
        jp.setList((i%2==0?true:false));
        jp.setDescription("description"+i);

        jp.setRoles(makeListOfString("role", i));
        jp.setBundle(makeListBundles(i));

        return jp;
    }

    private List<String> makeListOfString(String str, int n) {
        List<String> ls = new ArrayList<>();
        for (int i=0; i<n; i++) {
            ls.add(str + n + " " + i);
        }
        return ls;
    }

    private List<Bundle> makeListBundles(int n) {
        List<Bundle> lb = new ArrayList<>();
        for (int i=0; i<n; i++) {
            lb.add(makeBundle(i));
        }
        return lb;
    }

    private Bundle makeBundle(int n) {
        Bundle b = new Bundle();
        b.setValues(makeListOfString("value",n));
        b.setPath(makeListPath(n));
        return b;
    }

    private List<Path> makeListPath(int n) {
        List<Path> lp = new ArrayList<>();
        for (int i=0; i<n; i++) {
            Path p = new Path();
            p.setCode("pathCode" + n + " " + i);
            p.setValue("pathValue" + n + " " + i);
            lp.add(p);
        }
        return lp;
    }
}
