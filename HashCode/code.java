import java.util.*;

public class code {
    public static Scanner in = new Scanner(System.in);

    public static class Skill {
        String sname;
        int lev;

        Skill(String n, int l) {
            sname = n;
            lev = l;
        }
    }

    public static class Project implements Comparable<Project> {
        String pname;
        int reqDays;
        int point;
        int bestBef;
        ArrayList<Skill> tech;

        Project(String pname) {
            this.pname = pname;
        }

        public int compareTo(Project b) {
            if (this.tech.size() < b.tech.size()) {
                return -1;
            } else if (this.tech.size() > b.tech.size()) {
                return 1;
            } else if (this.bestBef < b.bestBef) {
                return -1;
            } else if (this.bestBef > b.bestBef) {
                return 1;
            } else if (this.reqDays < b.reqDays) {
                return -1;
            } else if (this.reqDays > b.reqDays) {
                return 1;
            } else {
                return this.point - b.point;
            }
        }
    }

    public static class Person {
        String name;
        HashMap<String, Integer> skills;

        Person(String name) {
            this.name = name;
        }
    }

    public static void personInput(Person[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            String name = in.next();
            Person p = new Person(name);
            int noOfSkills = in.nextInt();
            while (noOfSkills-- > 0) {
                String tech = in.next();
                int lev = in.nextInt();
                p.skills = new HashMap<>();
                p.skills.put(tech, lev);
            }
            arr[i] = p;
        }
    }

    public static void projectInput(Project[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            String name = in.next();
            Project p = new Project(name);
            int rd = in.nextInt();
            p.reqDays = rd;
            int poin = in.nextInt();
            p.point = poin;
            int bb = in.nextInt();
            p.bestBef = bb;
            int sk = in.nextInt();
            while (sk-- > 0) {
                String ski = in.next();
                int lev = in.nextInt();
                p.tech = new ArrayList<>();
                p.tech.add(new Skill(ski, lev));
            }
            arr[i] = p;
        }
    }

    public static void displayPerson(Person[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i].name + " -> " + arr[i].skills);
        }
    }

    public static void displayProject(Project[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i].pname + " " + arr[i].tech);
        }
    }

    public static void projectPriority(Project[] arr, PriorityQueue<Project> pq) {
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }
    }

    public static HashMap<String, Boolean> avail;
    public static long helperbnkerehjayega(PriorityQueue<Project> pq, HashMap<String, ArrayList<Person>> hm) {
        long time = 0;
        long ans = 0;
        // boolean[] avail = new boolean[pq.size()];
        while(pq.size()!=0){
           Project pr = pq.remove();
           ArrayList<Skill> t = pr.tech;
           for(int i=0; i<t.size(); i++){
                Skill s = t.get(i);
                String sk = s.sname;
                int lev = s.lev;

                ArrayList<Person> p = hm.get(sk);

           }
        }
        return ans;
    }

    public static void main(String[] args) {

        int n = in.nextInt();
        int m = in.nextInt();
        Person[] contributors = new Person[n];
        personInput(contributors);
        // displayPerson(contributors);
        Project[] projects = new Project[m];
        projectInput(projects);
        // displayProject(projects);
        PriorityQueue<Project> pq = new PriorityQueue<>();
        projectPriority(projects, pq);
        HashMap<String, ArrayList<Person>> hm = new HashMap<>();
        for (int i = 0; i < contributors.length; i++) {
            Person p = contributors[i];
            // String name = p.name;
            for (String s : p.skills.keySet()) {
                if(!hm.containsKey(s)){
                    hm.put(s, new ArrayList<>());
                }
                
            }
        }
        avail = new HashMap<>();
        for(int i=0; i<n; i++){
            Person p = contributors[i];
            avail.put(p.name, false);
        }
        long ans = helperbnkerehjayega(pq, hm);
        // System.out.println(33);

        // Solve(contributors, projects);
    }
}