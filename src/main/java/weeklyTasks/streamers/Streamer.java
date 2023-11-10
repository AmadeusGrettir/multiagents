package weeklyTasks.streamers;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class Streamer {
    private String name;
    private int age;
    private int subscribers;
    private List<Platform> platforms;

}
