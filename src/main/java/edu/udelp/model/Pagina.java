package edu.udelp.model;

public class Pagina {

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url){
        this.url = url;
    }

    @Override
    public String toString(){
        return "url: " + url;
    }
}
