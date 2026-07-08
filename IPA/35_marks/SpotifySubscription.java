import java.util.Scanner;

class Spotify
{
    private int spotifyId;
    private String profileName;
    private String subscriptionType;
    private double subscriptionPrice;
    private String groupSessionAvailable;

    public Spotify(int spotifyId, String profileName, String subscriptionType, double subscriptionPrice,String groupSessionAvailable) {
        
        
        this.spotifyId = spotifyId;
        this.profileName = profileName;
        this.subscriptionType = subscriptionType;
        this.subscriptionPrice = subscriptionPrice;
        this.groupSessionAvailable = groupSessionAvailable;
        
    }

    public int getSpotifyId() {
        return spotifyId;
    }

    public void setSpotifyId(int spotifyId) {
        this.spotifyId = spotifyId;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(String subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    public double getSubscriptionPrice() {
        return subscriptionPrice;
    }

    public void setSubscriptionPrice(double subscriptionPrice) {
        this.subscriptionPrice = subscriptionPrice;
    }

    public String getGroupSessionAvailable() {
        return groupSessionAvailable;
    }

    public void setGroupSessionAvailable(String groupSessionAvailable) {
        this.groupSessionAvailable = groupSessionAvailable;
    }

    
}
public class SpotifySubscription {
    public static double findAvgSpotifySubsByType(Spotify[] profiles, String subscriptionType,String groupSessionAvailable)
    {
        double sum = 0;
        int count =0;

        for(Spotify pf : profiles)
        {
            if(pf.getSubscriptionType().equalsIgnoreCase(subscriptionType) && pf.getGroupSessionAvailable().equalsIgnoreCase(groupSessionAvailable))
            {
                sum+=pf.getSubscriptionPrice();
                count++;
            }
        }
         if(count==0)
        {
            return 0.0;
        }
        return sum/count;
    }
    public static void main(String args[])
    {

        Scanner sc = new Scanner(System.in);
        Spotify []profiles = new Spotify[4];

        for(int i =0;i<4;i++)
        {
            int spotifyId= sc.nextInt();
            sc.nextLine();
            String profileName = sc.nextLine();
            String subscriptionType = sc.nextLine();
            double subscriptionPrice = sc.nextDouble();
            sc.nextLine();
            String groupSessionAvailable = sc.nextLine();

            profiles[i] = new Spotify(spotifyId, profileName, subscriptionType, subscriptionPrice, groupSessionAvailable);
        }
            String subscriptionType = sc.nextLine();
            String groupSessionAvailaible = sc.nextLine();

           double ans = findAvgSpotifySubsByType(profiles, subscriptionType, groupSessionAvailaible);
           if(ans>0){
            System.out.println(ans);
           } 
        else{
            System.out.println("There are no such Spotify Subscription");
        }

            sc.close();
    }
    
}
