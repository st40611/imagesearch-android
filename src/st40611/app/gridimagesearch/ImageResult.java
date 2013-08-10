package st40611.app.gridimagesearch;

import java.io.Serializable;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ImageResult implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4793939399395281399L;
	private String fullUrl;
	private String thumbUrl;
	
	// Constructor
	public ImageResult(JSONObject json) {
		try {
			this.fullUrl = json.getString("url");
			this.thumbUrl = json.getString("tbUrl"); 
		} catch (JSONException e) {
			this.fullUrl = null;
			this.thumbUrl = null;
		}
	}
	
	public String getFullUrl() {
		return fullUrl;
	}
	
	public String getThumbUrl() {
		return thumbUrl;
	}
	
	public String toString() {
		return this.thumbUrl;
	}

	public static ArrayList<ImageResult> fromJSONArray(JSONArray imageJsonResults) {
		// TODO Auto-generated method stub
		ArrayList<ImageResult> results = new ArrayList<ImageResult>();
		for (int i = 0; i < imageJsonResults.length(); i++) {
			try {
				results.add(new ImageResult(imageJsonResults.getJSONObject(i)));
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return results;
	}

}
