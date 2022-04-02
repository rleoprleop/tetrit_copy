package seoultech.se.tetris.component.model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class ScoreDataManager {
    private final String KEY_SCORE = "점수";
    private final String KEY_NAME = "이름";
    private final String KEY_ARR = "score";
    private final String FILEPATH = "src/main/java/seoultech/se/tetris/component/model/ScoreData.json";
   // private final String FILEPATH = "seoultech/se/tetris/component/model/ScoreData.json";
    private ScoreDataManager() {

    }

    private static class LazyHolder {
        public static final ScoreDataManager dataManager = new ScoreDataManager();
    }

    public static ScoreDataManager getInstance() {
        return LazyHolder.dataManager;
    }

    private JSONArray readData() throws IOException, ParseException{
        JSONParser parser = new JSONParser();
        Reader reader = new FileReader(FILEPATH);
        JSONObject scoreObject = (JSONObject) parser.parse(reader);
        JSONArray scoreData = (JSONArray) scoreObject.get("score");
        //System.out.println(parser.parse(reader).toString());
        return scoreData;
    }

    private void writeData(String data) throws IOException {
        File jsonFile = new File(FILEPATH);
        BufferedWriter writer = new BufferedWriter(new FileWriter(jsonFile));
        writer.write(data);
        writer.close();
    }


    public void addScoreData(String name, int score){
        try {
            JSONArray scoreData = readData();
//            System.out.println(scoreData.toString());
//            System.out.println(scoreData.size());
           // JSONArray scoreData = new JSONArray();
            JSONObject data = new JSONObject();
            data.put(KEY_SCORE, score);
            data.put(KEY_NAME, name);
            scoreData.add(data);

            JSONObject keyArr = new JSONObject();
            keyArr.put(KEY_ARR, scoreData);

            writeData(keyArr.toJSONString());
        } catch (IOException | ParseException e){
            e.printStackTrace();
        }
    }

    public int getLastScore() {
        int score = 0;
        try {
            JSONArray scoreData = readData();
//            System.out.println(scoreData.size());
            if(scoreData.size() < 0) return 0;

            else {
                int lastIdx = scoreData.size()-1;
                JSONObject element = (JSONObject)scoreData.get(lastIdx);
                score =Integer.parseInt(element.get(KEY_SCORE).toString());

                return score;
            }
        } catch (IOException | ParseException | NumberFormatException e){
            e.printStackTrace();
        }
        return score;
    }
    public int fetchData (JSONArray scoreData){
        return 1;
    }
}
