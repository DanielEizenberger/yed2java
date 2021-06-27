public class ElectionUtilBasic {
public static String evaluate(String[] votes)
HashMap<String, Integer> candidates;
candidates.put(vote, 1);
}
candidates.put(s, candidates.get(vote) + 1);
}
for (String vote : votes){
if (candidates.get(vote) != null){
for (Map.Entry<String, Integer> candidate : candidates.entrySet()){
Map.Entry<String, Integer> winner = null;
if (votes.length != 0){
String result = "none";
return result;
candidates = new HashMap<>();
if (winner != null){
winner = candidate;
}
if (candidate.getValue()> winner.getValue()){
winner = candidate;
}
result = winner.getKey();
for (Map.Entry<String, Integer> candidate : candidates.entrySet()){
if (!candidate.equals(winner)){
result = "draw";
break;
}
if (candidate.getValue().equals(winner.getValue())){
}}