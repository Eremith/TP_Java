public class Pair {
    private int key;
    private String value;

    Pair(int key, String value){
        this.key = key;
        this.value = value;
    }

    int getKey(){
        return this.key;
    }
    String getValue(){
        return this.value;
    }

    void setKey(int key){
        this.key = key;
    }
    void setValue(String value){
        this.value = value;
    }
}
