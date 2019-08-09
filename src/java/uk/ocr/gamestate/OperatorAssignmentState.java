package uk.ocr.gamestate;

import org.bukkit.entity.Player;
import uk.ocr.containers.PlayerOperatorContainer;
import uk.ocr.operators.Operator;
import uk.ocr.operators.OperatorMap;
import uk.ocr.operators.OperatorName;

import java.util.HashMap;
import java.util.List;

public class OperatorAssignmentState {

    private HashMap<Operator, Boolean> operatorAssignementCheck;
    private List<PlayerOperatorContainer> currentOperatorList;

    public Boolean assignOperator(Player player, OperatorName operatorRequestName) {
        Operator operator = OperatorMap.getOperatorByName(operatorRequestName);
        if (!checkIsOpereatorIsInUse(operator)){
            currentOperatorList.add(new PlayerOperatorContainer(operator,player));
            operatorAssignementCheck.put(operator, true);
            return true;
        }else{
            return false;
        }
    }

    public Boolean unassignOperator(Player player, OperatorName operatorRequestName) {
        Operator operator = OperatorMap.getOperatorByName(operatorRequestName);
        if (checkIsOpereatorIsInUse(operator)){
            operatorAssignementCheck.remove(operator);
            return true;
        }else{
            return false;
        }
    }

    private Boolean checkIsOpereatorIsInUse(Operator operator){
        return (operatorAssignementCheck.containsKey(operator));
    }

}