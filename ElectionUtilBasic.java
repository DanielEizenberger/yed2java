import java.util.HashMap;
import java.util.Map;
public final class ElectionUtilBasic {
String result = "none";
if (votes.length != 0){{
HashMap<String, Integer> candidates;
candidates = new HashMap<>();
for (String vote : votes){{
if (candidates.get(vote) != null){{
candidates.put(s, candidates.get(vote) + 1);
}
Map.Entry<String, Integer> winner = null;
for (Map.Entry<String, Integer> candidate : candidates.entrySet()){{
if (winner != null){{
if (candidate.getValue()> winner.getValue()){{
winner = candidate;
}
result = winner.getKey();
for (Map.Entry<String, Integer> candidate : candidates.entrySet()){{
if (!candidate.equals(winner)){{
if (candidate.getValue().equals(winner.getValue())){{
result = "draw";
break;
}
return result;
}}