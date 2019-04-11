package state.actiondecision;

import state.action.IAction;
import state.agent.IAgent;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to decide when to do an action, and execute that action if necessary
 * @author David Miron
 * @author Jorge Raad
 */
public class ActionDecision {

    private IAction action;
    private List<ICondition> conditions;

    protected ActionDecision(IAction action, List<ICondition> conditions){
        this.action = action;
        this.conditions = conditions;
    }

    /**
     * Execute the action on agents passed, after filtering based on conditions
     * @param agents The list of active agents
     */
    public void execute(List<IAgent> agents) {
        List<IAgent> agentsFiltered = new ArrayList<>(agents);

        for (ICondition condition: conditions)
            agentsFiltered = condition.getValid(agentsFiltered);

        for (IAgent agent: agentsFiltered)
            action.execute(agent);
    }

}
