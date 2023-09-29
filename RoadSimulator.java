public class RoadSimulator
{
    public static void main(String[] args)
    {
        System.out.println("Welcome to road simulator.");
        
        //Setup Traffic Map
        TrafficMap trafficMap = new TrafficMap(60, 20);
        trafficMap.initTrafficMap();
        
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        trafficMap.startTraffic();

    }

}