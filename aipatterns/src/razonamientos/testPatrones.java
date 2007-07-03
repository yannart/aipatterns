
package razonamientos;

import razonamientos.Rule;
import razonamientos.OperatorType;

import razonamientos.StatementRepeatedException;
import java.util.ArrayList;
import java.util.List;

public class testPatrones {
    
    /** Creates a new instance of test2 */
    public testPatrones() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            KnowledgeBase bc = new KnowledgeBase("h7","h8");
            ReasoningForward r = new ReasoningForward(createRules(),bc,"h2");
            /*
            Rule rule1 = r.getRuleToApply();
            System.out.println("la regla a plicar es: "+rule1.getNumberRule());
            r.applyRuleOnBase(rule1);
            
            Rule rule2 = r.getRuleToApply();
            System.out.println("la regla a plicar es: "+rule2.getNumberRule());
            r.applyRuleOnBase(rule2);
            
            Rule rule3 = r.getRuleToApply();
            System.out.println("la regla a plicar es: "+rule3.getNumberRule());
            r.applyRuleOnBase(rule3);
            
            Rule rule4 = r.getRuleToApply();
            System.out.println("la regla a plicar es: "+rule4.getNumberRule());
            r.applyRuleOnBase(rule4);
            
            Rule rule5 = r.getRuleToApply();
            System.out.println("la regla a plicar es: "+rule5.getNumberRule());
            r.applyRuleOnBase(rule5);
            
            Rule rule6 = r.getRuleToApply();
            System.out.println("la regla a plicar es: "+rule6.getNumberRule());
            r.applyRuleOnBase(rule6);
            
           int a = 0;
            if(r.testTarget()){
                System.out.println("objetivo cumplido");
            }
             */
            while(r.hasMoreElements()){
                Rule rule = (Rule)r.nextElement();
                r.applyRuleOnBase(rule);
                System.out.println(rule.toString());
            }
            
        } catch (StatementRepeatedException ex) {
            ex.printStackTrace();
        }
    }

    private static List<Rule> createRules() throws StatementRepeatedException {
        List<Rule> rules = new ArrayList();
        Rule rule1 = new Rule(OperatorType.AND);
        rule1.setStatement("h8");
        rule1.setStatement("h6");
        rule1.setStatement("h5");
        rule1.setResult("h4");
        
        
        Rule rule2 = new Rule(OperatorType.AND);
        rule2.setStatement("h6");
        rule2.setStatement("h3");
        rule2.setResult("h9");
        
        
        Rule rule3 = new Rule(OperatorType.AND);
        rule3.setStatement("h7");
        rule3.setStatement("h4");
        rule3.setResult("h9");
        
        
        Rule rule4 = new Rule(OperatorType.AND);
        rule4.setStatement("h8");
        rule4.setResult("h1");
        
        
        Rule rule5 = new Rule(OperatorType.AND);
        rule5.setStatement("h6");
        rule5.setResult("h5");
        
        
        Rule rule6 = new Rule(OperatorType.AND);
        rule6.setStatement("h9");
        rule6.setStatement("h1");
        rule6.setResult("h2");
        
        
        Rule rule7 = new Rule(OperatorType.AND);
        rule7.setStatement("h7");
        rule7.setResult("h6");
        
        
        Rule rule8 = new Rule(OperatorType.AND);
        rule8.setStatement("h1");
        rule8.setStatement("h7");
        rule8.setResult("h9");
        
        
        Rule rule9 = new Rule(OperatorType.AND);
        rule9.setStatement("h1");
        rule9.setStatement("h8");
        rule9.setResult("h6");
        
        
        rules.add(rule1);
        rules.add(rule2);
        rules.add(rule3);
        rules.add(rule4);
        rules.add(rule5);
        rules.add(rule6);
        rules.add(rule7);
        rules.add(rule8);
        rules.add(rule9);
        return rules;
    }
}