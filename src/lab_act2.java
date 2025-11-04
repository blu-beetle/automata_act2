import java.util.*;
public class lab_act2 {
//declaring NFA transitions
	static Map<String, Map<Character, Set<String>>> transition = new HashMap<>();
	
	//initialize all transitions
	static {
		//q0 transitions(start state)
		transition.put("q0", new HashMap<>());
		transition.get("q0").put('a', new HashSet<>(Arrays.asList("q0", "q1")));
		transition.get("q0").put('b', new HashSet<>(Arrays.asList("q0")));
	
		//q1 transitions
		transition.put("q1", new HashMap<>());
		transition.get("q1").put('a', new HashSet<>(Arrays.asList("q1")));
		transition.get("q1").put('b', new HashSet<>(Arrays.asList("q2")));
		
		//q2 transitions(accept state)
		transition.put("q2", new HashMap<>());
		transition.get("q2").put('a', new HashSet<>(Arrays.asList("q2")));
		transition.get("q2").put('b', new HashSet<>(Arrays.asList("q2")));
	}
	
	//simulates the NFA
	static boolean simulate(String input) {
		Set<String> currentState = new HashSet<>();
		currentState.add("q0"); //start state
		
		for(char ch : input.toCharArray()) {
			Set<String> nextState = new HashSet<>();
			
			//explore all transitions
			for (String state : currentState) {
				if (transition.containsKey(state) && transition.get(state).containsKey(ch)) {
					nextState.addAll(transition.get(state).get(ch));
				}
			}
			currentState = nextState;
		}
		
		// returns q2(accept state)
					return currentState.contains("q2");
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String input = scan.nextLine();
		input = input.toLowerCase();
		
		if (simulate(input)) {
			System.out.println("Output : Accepted");
		} else {
			System.out.println("Output : Rejected");
		}
		scanner.close();
	}
}
