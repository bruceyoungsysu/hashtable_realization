import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.LinkedList;
import java.util.function.BiConsumer;

class Node {
    Object key = null;
    Object value = null;
}

class Hashele {
    Object hashkey = null;
    LinkedList<Node> ll = new LinkedList();
}

public class Hashtable {
    int len = 0;
    int count = 0;
    ArrayList<Hashele> hash = new ArrayList();

    public ArrayList<Hashele> inithash() {
        int l=10;
        return inithash(l);
    }

    public ArrayList<Hashele> inithash(int l) {

        int i = 0;
        this.len = l;
        this.hash = new ArrayList();
        IntStream stream = IntStream.range(0, len);
        stream.forEach(item ->
        {
            this.hash.add(new Hashele());
        });
        return this.hash;
    }

    public int inserthash(Object key, Object ob)  //insert an element with key and val=ob
    {
        int hashaddress = key.hashCode();
        int hashkey = hashaddress % len;
        LinkedList<Node> l = new LinkedList();
        Node nd = new Node();
        nd.key = key;
        nd.value = ob;
        if(hash.get(hashkey).ll.size() == 0){
            count += 1;
         }
        hash.get(hashkey).ll.add(nd);
        if (count >= this.len*0.75 ){
            this.hash = resize();
        }
        return 1;

    }

    public void iteratehash(BiConsumer<? super Object, ? super Object> action) {
        this.hash.forEach(he -> he.ll.forEach(nd -> {
            Node node = nd;
            action.accept(node.key, node.value);
        }));
    }

    public ArrayList<Hashele> resize() {
        ArrayList<Hashele> bk_hash = new ArrayList();
        bk_hash = this.hash;
        inithash(this.len * 2);
        this.count = 0;
        bk_hash.forEach(he -> he.ll.forEach(nd -> {
            Node node = nd;
            this.inserthash(node.key,node.value);
        }));

        //bk_hash.forEach(he -> {
        //    if(he.ll.size() != 0) {
        //        int hash_ad = he.ll.get(0).key.hashCode();
        //        int new_key = (hash_ad) % (this.len);
        //        System.out.println(this.len * 2);
        //        this.hash.get(new_key).ll = he.ll;
        //    }
        //});
        return this.hash;
    }


    public static void main(String[] args) {
        Hashtable h = new Hashtable();
        h.inithash(5);
        h.inserthash("1", "sss");
        h.inserthash("1","bbb");
        h.inserthash("2","qqq");
        h.inserthash("2","vvv");
        h.inserthash("3","fff");
        h.inserthash(0,"ccc");
        System.out.println(h.hash.size());
        h.iteratehash((k,v)->{
            System.out.format("key: %s, value:%s \n", k, v);
        });
    }
}