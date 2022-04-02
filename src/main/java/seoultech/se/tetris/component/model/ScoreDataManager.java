package seoultech.se.tetris.component.model;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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

    private JSONArray readData() {
        JSONArray scoreData = new JSONArray();
        try{
            JSONParser parser = new JSONParser();
            Reader reader = new FileReader(FILEPATH);
            JSONObject scoreObject = (JSONObject) parser.parse(reader);
            scoreData = (JSONArray) scoreObject.get("score");
            //System.out.println(parser.parse(reader).toString());
        } catch (IOException | ParseException e){
            e.printStackTrace();
        }

        return scoreData;
    }

    private void writeData(String data){
        try {
            File jsonFile = new File(FILEPATH);
            BufferedWriter writer = new BufferedWriter(new FileWriter(jsonFile));
            writer.write(data);
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }


    public void addScoreData(String name, int score){
        JSONArray scoreData = readData();
//            System.out.println(scoreData.toString());
//            System.out.println(scoreData.size());
           // JSONArray scoreData = new JSONArray();
        JSONObject data = new JSONObject();
        data.put(KEY_SCORE, score);
        data.put(KEY_NAME, name);
        scoreData.add(data);

        fetchData(scoreData);
    }

    public int getLastScore() {
        int score = 0;
        JSONArray scoreData = readData();
        if(scoreData.size() <= 0) return 0;

        else {
            int lastIdx = scoreData.size() - 1;
            JSONObject element = (JSONObject) scoreData.get(lastIdx);
            score = Integer.parseInt(element.get(KEY_SCORE).toString());
            return score;
        }

    }
    public void fetchData (JSONArray scoreData){
        JSONArray sortedData = new JSONArray();

        List<JSONObject> jsonValues = new ArrayList<JSONObject>();
        for(int i = 0; i<scoreData.size(); i++) {
            jsonValues.add((JSONObject) scoreData.get(i));
        }

        Collections.sort(jsonValues, new Comparator<JSONObject>() {
            @Override
            public int compare(JSONObject a, JSONObject b) {
                int scoreA;
                int scoreB;

                scoreA = Integer.parseInt(a.get(KEY_SCORE).toString());
                scoreB = Integer.parseInt(b.get(KEY_SCORE).toString());


                return -Integer.compare(scoreA, scoreB);
            }
        });

        JSONObject keyArr = new JSONObject();
        keyArr.put(KEY_ARR, jsonValues);
        writeData(keyArr.toString());
    }

//    public int getRowsFromTable(String name, int score){
//        int idx = 0;
//        try{
//            JSONArray scoreData = readData();
//            int scoreDataSize = scoreData.size();
//
//            for(int i = 0; i<scoreDataSize; i++){
//                JSONObject element = (JSONObject)scoreData.get(i);
//                int sc =Integer.parseInt(element.get(KEY_SCORE).toString());
//                String str = element.get(KEY_NAME).toString();
//                if(str == name && score == sc){
//                    idx = i;
//                    break;
//                }
//            }
//
//        } catch (IOException | ParseException e){
//            e.printStackTrace();
//        }
//        return idx;
//    }

    public String[][] getStringData(){
        JSONArray scoreData = readData();
        String stringData[][] = new String[scoreData.size()][3];
        for(int i = 0; i< scoreData.size(); i++){
            JSONObject element = (JSONObject) scoreData.get(i);
            stringData[i][0] = Integer.toString(i+1);
            stringData[i][1] = element.get(KEY_NAME).toString();
            stringData[i][2] = element.get(KEY_SCORE).toString();
        }

        return stringData;
    }
}
