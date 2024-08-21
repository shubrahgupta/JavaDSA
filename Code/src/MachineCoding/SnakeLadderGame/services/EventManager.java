package MachineCoding.SnakeLadderGame.services;

import MachineCoding.SnakeLadderGame.Model.Player;
import MachineCoding.SnakeLadderGame.Model.Snake;

public class EventManager {
    Player player;
    int dieFaceNumber;
    Event eventStage;

    public EventManager(Player player, int dieFaceNumber) {
        this.player = player;
        this.dieFaceNumber = dieFaceNumber;
        this.eventStage = Event.incomplete;
    }
    public void positionJustAfterDieRolling() {
        int positionBeforeEvent = this.player.getPosition();
        if (positionBeforeEvent + dieFaceNumber > Constants.WINNING_POSITION){
            this.player.setPosition(positionBeforeEvent);
            this.eventStage = Event.finished;
        }
        else if (positionBeforeEvent + dieFaceNumber == Constants.WINNING_POSITION) {
            this.player.setPosition(Constants.WINNING_POSITION);
            this.eventStage = Event.finished;
        }
        else {
            this.player.setPosition(positionBeforeEvent + dieFaceNumber);
        }


    }
    public int finalPositionAfterEvent(){
        positionJustAfterDieRolling();
        int finalPosition = this.player.getPosition();
//        System.out.println(finalPosition);

//        while(this.eventStage != Event.finished) {
//            int check1 = finalPosition;
//            int checkSnakeBitePosition = GameManager.isSnakeBitePosition(finalPosition);
//            if (checkSnakeBitePosition != -1){
//                finalPosition = checkSnakeBitePosition;
//            }
//            int check2 = finalPosition;
//            int ladderHikePosition = GameManager.isLadderHikePosition(finalPosition);
//            if (ladderHikePosition != -1) {
//                finalPosition = ladderHikePosition;
//            }
//            int check3 = finalPosition;
//
//        }
        while (true) {  // Continue checking until no more events occur
            int checkSnakeBitePosition = GameManager.isSnakeBitePosition(finalPosition);
            if (checkSnakeBitePosition != -1) {
                finalPosition = checkSnakeBitePosition;
            } else {
                int ladderHikePosition = GameManager.isLadderHikePosition(finalPosition);
                if (ladderHikePosition != -1) {
                    finalPosition = ladderHikePosition;
                } else {
                    break;
                }
            }
        }
        this.player.setPosition(finalPosition);
        return finalPosition;

    }
    public String commmentary() {
        String winningComment = this.player.getName() + " wins the game";
        if (this.player.getStatus() == Constants.INCONCLUSIVE_POSITION)
        {
            int positionBeforeEvent = this.player.getPosition();

            int positionAfterEvent = finalPositionAfterEvent();
            String genericComment = this.player.getName() + " rolled a " + dieFaceNumber + " and moved from " + positionBeforeEvent + " to " + positionAfterEvent;

            if (positionAfterEvent == Constants.WINNING_POSITION)
                return genericComment + "\n" + winningComment;
            else return genericComment;

        }
        else {
            return winningComment;
        }
    }


}
