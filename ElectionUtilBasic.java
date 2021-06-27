import java.util.HashMap;
import java.util.Map;
public final class ElectionUtilBasic {
String
if (winner != null){
winner = candidate;
}
result = "draw";
candidates = new HashMap<>();
HashMap<String, Integer> candidates;
return result;
if (candidate.getValue().equals(winner.getValue())){
for (String vote : votes){
for (Map.Entry<String, Integer> candidate : candidates.entrySet()){
String result = "none";
String[] votes
candidates.put(s, candidates.get(vote) + 1);
}
winner = candidate;
}
candidates.put(vote, 1);
}
if (votes.length != 0){
result = winner.getKey();
if (candidate.getValue()> winner.getValue()){
if (!candidate.equals(winner)){
if (candidates.get(vote) != null){
public static String evaluate(String[] votes)
for (Map.Entry<String, Integer> candidate : candidates.entrySet()){
break;
}
Map.Entry<String, Integer> winner = null;
}}