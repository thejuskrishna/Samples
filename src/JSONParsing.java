import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class JSONParsing {

	public static void main(String args[])
	{
		String jsonText = null;
		try {
			jsonText = readJSON("src/sample.json");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HashMap<String, String> jsonVals = new HashMap<>();
		
		try {
			jsonVals = extractJSON(jsonText);
			System.out.println("JSONVals "+ jsonVals.toString());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static HashMap<String, String> extractJSON(String jsonText) throws JSONException
	{
		int i;
		HashMap<String, String> jsonValues = new HashMap<>();
		if (jsonText != null) {
			JSONObject obj = new JSONObject(jsonText);
			JSONArray arrayOfTests = (JSONArray) ((JSONObject)obj.get("Groups")).get("Test");
			
			for(i = 0; i < arrayOfTests.length(); i++) {
				String testNumber = arrayOfTests.getJSONObject(i).getString("Test Number");
				String environment = arrayOfTests.getJSONObject(i).getString("environment");
				jsonValues.put("Test Number", testNumber);
				jsonValues.put("environment", environment);
				
			}
		}
		return jsonValues;
	}
	
	public static String readJSON(String file) throws IOException
	{
		FileInputStream in = new FileInputStream(file);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String jsonLine = br.readLine();
		StringBuilder jsonText = new StringBuilder(); 
		while(jsonLine!=null)
		{
			jsonText.append(jsonLine);
			jsonLine = br.readLine();
		}
		
		System.out.println("JSON File\n" + jsonText.toString().trim());
		return jsonText.toString().trim();
	}
}
