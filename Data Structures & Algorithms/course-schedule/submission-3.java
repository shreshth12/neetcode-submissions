class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create an adjacency list to keep track of directed graph of courses
        // and populate it according to the prerequisites
        Map<Integer, ArrayList<Integer>> coursesMap = new HashMap<>();
        for(int courseNumber = 0; courseNumber < numCourses; courseNumber++){
            coursesMap.put(courseNumber, new ArrayList<Integer>());
        }
        for(int[] prerequisite: prerequisites){
            ArrayList<Integer> preqList = coursesMap.get(prerequisite[0]);
            preqList.add(prerequisite[1]);
            coursesMap.put(prerequisite[0], preqList);
        }

        // Create a set to keep track of which courses are being taken
        Set<Integer> coursesInProgress = new HashSet<>();

        // Start at course 0, and check if we can finish all courses
        for(int courseNumber = 0; courseNumber < numCourses; courseNumber++){
            if(dfs(coursesMap, coursesInProgress, courseNumber) == false){
                return false;
            }
        }

        // If we never returned false, meaning we could complete all the courses
        return true;
    }

    public boolean dfs(
        Map<Integer, ArrayList<Integer>> coursesMap, 
        Set<Integer> coursesInProgress,
        int currCourse
    ){
        // Check if we are in a cycle
        if(coursesInProgress.contains(currCourse)){return false;}

        // Check if the currentCourse has no preqs, return immediately
        if(coursesMap.get(currCourse).isEmpty()){return true;}

        // Mark the current course as taken in the set
        // and proceed to its preqs
        coursesInProgress.add(currCourse);
        for(int preqCourse: coursesMap.get(currCourse)){
            if(dfs(coursesMap, coursesInProgress, preqCourse) == false){
                return false;
            }
        }

        // If we never returned false, meaning we could reach the end
        // Remove the current course from being inProgress and
        // mark its preqs as empty arraylist to avoid computation chain
        coursesInProgress.remove(currCourse);
        coursesMap.put(currCourse, new ArrayList<Integer>());
        return true;
    }
}
