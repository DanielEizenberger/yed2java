import java.util.HashMap;
import java.util.Map;
public final class ElectionUtilBasic {
return result;}
if (candidate.getValue()> winner.getValue()){{
result = "draw";
public static String evaluate(String[] votes)
if (candidates.get(vote) != null){{
HashMap<String, Integer> candidates;
Map.Entry<String, Integer> winner = null;
for (Map.Entry<String, Integer> candidate : candidates.entrySet()){{
if (candidate.getValue().equals(winner.getValue())){{
if (votes.length != 0){{
for (Map.Entry<String, Integer> candidate : candidates.entrySet()){{
if (!candidate.equals(winner)){{
break;
}
winner = candidate;
}
for (String vote : votes){{
candidates = new HashMap<>();
candidates.put(s, candidates.get(vote) + 1);
}
String result = "none";
String
String[] votes
result = winner.getKey();
if (winner != null){{
winner = candidate;
}
candidates.put(vote, 1);
}
}}