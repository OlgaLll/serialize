package homework.v3;

import homework.v3.entityext.BundleExt;
import homework.v3.entityext.JsonFileClassExt;
import homework.v3.entityext.JsonParametersExt;
import homework.v3.entityext.PathExt;

import java.util.ArrayList;
import java.util.List;

public class MakeObjectExt {
    public JsonFileClassExt makeObject(int n) {
        JsonFileClassExt jc = new JsonFileClassExt();
        jc.setVersion("1.0");
        jc.setParameters(makeListJsonParameters(n));
        return jc;
    }

    private List<JsonParametersExt> makeListJsonParameters(int n) {
        List<JsonParametersExt> jpl = new ArrayList<>();
        for (int i=0; i<n; i++) {
            jpl.add(makeJsonParameters(i));
        }
        return jpl;
    }

    private JsonParametersExt makeJsonParameters(int i) {
        JsonParametersExt jp = new JsonParametersExt();
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

    private List<BundleExt> makeListBundles(int n) {
        List<BundleExt> lb = new ArrayList<>();
        for (int i=0; i<n; i++) {
            lb.add(makeBundle(i));
        }
        return lb;
    }

    private BundleExt makeBundle(int n) {
        BundleExt b = new BundleExt();
        b.setValues(makeListOfString("value",n));
        b.setPath(makeListPath(n));
        return b;
    }

    private List<PathExt> makeListPath(int n) {
        List<PathExt> lp = new ArrayList<>();
        for (int i=0; i<n; i++) {
            PathExt p = new PathExt();
            p.setCode("pathCode" + n + " " + i);
            p.setValue("pathValue" + n + " " + i);
            lp.add(p);
        }
        return lp;
    }
}

