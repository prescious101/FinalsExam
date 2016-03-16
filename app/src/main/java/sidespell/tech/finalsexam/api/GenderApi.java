package sidespell.tech.finalsexam.api;

import android.net.Uri;
import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONObject;

import sidespell.tech.finalsexam.utils.HttpUtils;

public class GenderApi {

    public static final String BASE_URL = "https://api.genderize.io/";
    private static final String TAG_NAME = "name";
    private static final String TAG_GENDER= "gender";

//    List<Gender> genderList = new ArrayList<>();


    public static String getGender(String name) {
        Uri uri = Uri.parse(BASE_URL).buildUpon()
                .appendQueryParameter("name", name)
                .build();

        String jsonStr = HttpUtils.GET(uri);

        if (!TextUtils.isEmpty(jsonStr)) {

            JSONArray jsonArray;
            JSONObject jsonObject;

            try {
                // TODO: Implement JSON Parsing here..
                jsonArray = new JSONArray(jsonStr);
                for (int i = 0; i < jsonArray.length(); i++) {
                    jsonObject = jsonArray.getJSONObject(i);
                    String pname = jsonObject.getString(TAG_NAME);
                    String gender = jsonObject.getString(TAG_GENDER);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
