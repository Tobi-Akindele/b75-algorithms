package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CourseSchedule {
	
	Map<Integer, List<Integer>> preMap = new HashMap<>();
	Set<Integer> visitSet;
	
	public static void main(String[] args) {
		System.out.println(new CourseSchedule().canFinish(2, new int[][] {{1,0}})); // should return true
		
		System.out.println(new CourseSchedule().canFinish(2, new int[][] {{1,0},{0,1}})); // should return false
	}

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		
		// Map each course to prerequisite list
		preMap = mapPrerequisiteToCourse(prerequisites);
		
		// visitSet = all courses along the curr DFS path
		visitSet = new HashSet<>();
		
		for(int i = 0; i < numCourses; i++) {
			if(!dfs(i)) {
				return false;
			}
		}
		return true;
	}
	
	private Map<Integer, List<Integer>> mapPrerequisiteToCourse(int[][] prr) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		
		for(int i = 0; i < prr.length; i++) {
			if(map.containsKey(prr[i][0])) {
				map.get(prr[i][0]).add(prr[i][1]);
			} else {
				List<Integer> prrList = new ArrayList<>();
				prrList.add(prr[i][1]);
				map.put(prr[i][0], prrList);
			}
		}
		return map;
	}
	
	private boolean dfs(int crs) {
		if(visitSet.contains(crs)) {
			return false;
		}
		if(preMap.get(crs) == null || preMap.get(crs).isEmpty()) {
			return true;
		}
		
		visitSet.add(crs);
		for(int pre: preMap.get(crs)) {
			if(!dfs(pre)) {
				return false;
			}
		}
		visitSet.remove(crs);
		preMap.put(crs, new ArrayList<>());
		return true;
	}
}
