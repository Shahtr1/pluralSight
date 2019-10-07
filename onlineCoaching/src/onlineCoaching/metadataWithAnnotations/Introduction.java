/*
 * 	The Need to Express Context and Intent
 * 		Type system solves much of this issue
 * 		But standard type system isn't quite enough
 * 
 */

/*
 * 	Annotations in code
 * 		Name always preceded by @ when used
 * 		Placed directly before target
 * 		Allowable targets vary with annotation
 */

/*
 * 	Annotations and the core Java platform
 * 		Types to create annotations
 * 		Has only a few annotations
 * 
 * 	Widely used by other tools/environments
 * 		Java EE
 * 		XML processors such as JAXP
 * 		Your code??
 */

/*
 * 	Common Java core platform annotations
 * 		Override
 * 		Deprecated
 * 		SuppressWarnings
 */

package onlineCoaching.metadataWithAnnotations;


public class Introduction {
	@SuppressWarnings("deprecation")
	static void doSomeWork() {
		Doer d = new Doer();
		d.doItThisWay();
	}
	
	@SuppressWarnings("deprecation")
	static void doDoubleWork() {
		Doer d1 = new Doer();
		Doer d2 = new Doer();
		d1.doItThisWay();
		d2.doItThisWay();
	}
	
	public static void main(String[] args) {
		doSomeWork();
		doDoubleWork();
	}
}

class Doer{
	@Deprecated
	void doItThisWay() {
		System.out.println("old");
	}
	void doItThisNewWay() {
		System.out.println("new");
	}
}












