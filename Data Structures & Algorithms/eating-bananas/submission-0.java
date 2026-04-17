class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        /*
        The value of "h" can never be less than the length of piles. Let's say hours to
        eat was 1 but the piles to eat was 2. In that case, koko can never eat all since
        she can only eat one pile in one hour.

        The maximum speed at which she can eat is at the maximum size of a particular
        pile, making eating it take a single hour, that means every other will also take
        a single hour ( every other would be smaller ).

        Using this idea, we can think of bounds of speed: 1 to maximum pile size
        */

        // Get the min/max speed at which koko can eat the largest pile in 1 hour
        int answer = 0;
        int minSpeed = 1;
        int maxSpeed = 1;
        for(int pileSize: piles){
            if(pileSize > maxSpeed){maxSpeed = pileSize;}
        }

        // Go through the bounds of speed to know the minimum speed to eat all
        while(minSpeed <= maxSpeed){
            // Get the averageSpeed
            int averageSpeed = minSpeed + (maxSpeed - minSpeed) / 2;

            // If at this speed, koko can eat all, lets try a smaller one
            if(eatCheck(piles, averageSpeed, h) == true){
                answer = averageSpeed;
                maxSpeed = averageSpeed - 1;
            }
            // If at this speed, koko cannot eat all, increase the speed
            else if(eatCheck(piles, averageSpeed, h) == false){
                minSpeed = averageSpeed + 1;
            }
        }
        // return the answer
        return answer;
    }

    // Create a function to check if a given speed can be used to
    // eat all piles of bananas in "h" hour
    public boolean eatCheck(int[] piles, int speed, int h){
        int atPile = 0;
        for(int pileSize: piles){
            if(h <= 0){
                break;
            }
            if(speed >= pileSize){
                h--;
                atPile++;
            }
            else{
                h = h - ((int) pileSize/speed + (int) Math.min(1, pileSize%speed));
                atPile++;
            }
        }
        return (atPile == piles.length && h >= 0) ? true : false;
    }
}
