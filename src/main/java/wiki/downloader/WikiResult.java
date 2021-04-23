package wiki.downloader;

import com.sun.org.apache.xpath.internal.objects.XString;

public class WikiResult {

    private String query;
    private String textResult;
    private String imageURL;

    public WikiResult(){

    }

    public WikiResult(String keyWord, String response, String imageURL) {
        this.query = keyWord;
        this.textResult = response;
        this.imageURL = imageURL;
    }
    public String getTextResult(){
        return textResult;
    }
}
