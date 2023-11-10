package weeklyTasks.streamers;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

//ДЗ:
//  - Создать класс Streamer: (String name, double averageMark, int age, int subscribers, List<Platform> platforms,)
//  - Создать класс Platform (String name, boolean isRoscomnadzored)
//Сделать три разных платформы и 10-12 стримеров на них.

        List<Platform> platforms = new ArrayList<>(List.of(
                new Platform("Youtube", false),
                new Platform("Twitch", true),
                new Platform("BiliBili", false)
        ));

        List<Streamer> streamers = new ArrayList<>(List.of(
                new Streamer("Gawr Gura", 9_927, 4_400_000, List.of(platforms.get(0))),
                new Streamer("Kizuna AI", 5, 3_010_000, List.of(platforms.get(0), platforms.get(2))),
                new Streamer("Houshou Marine", 17, 2_790_000, List.of(platforms.get(0), platforms.get(2))),
                new Streamer("Usada Pekora", 111, 2_330_000, platforms),
                new Streamer("filian", 37, 2_260_000, List.of(platforms.get(1))),
                new Streamer("Ironmouse", 6_669, 1_745_688, List.of(platforms.get(0), platforms.get(1))),
                new Streamer("Shylily", 26, 1_225_589, List.of(platforms.get(0), platforms.get(1))),
                new Streamer("Kagura Nana", 16, 2_072_946, List.of(platforms.get(0), platforms.get(2))),
                new Streamer("Nyatasha Nyanners", 30, 1_460_000, List.of(platforms.get(1))),
                new Streamer("Shirakami Fubuki", 18, 2_230_000, List.of(platforms.get(0)))

        ));

//        задачи:
//        1) Найти всех стримеров старше 21 года и с более 15к подсписчиков на платформе twitch

        Set<String> streamers_1 = streamers.stream()
                .filter(s -> s.getPlatforms().contains((platforms.get(0))))
                .filter(s -> s.getAge() > 21)
                .filter(s -> s.getSubscribers() > 15_000)
                .map(s -> s.getName())
                .collect(Collectors.toSet());

        System.out.println(streamers_1);

//        2) Найти самого молодого стримера на незаболкированной платформе

        Optional<String> streamers_2 = streamers.stream()
                .filter(streamer -> streamer.getPlatforms()
                        .stream()
                        .allMatch(platform -> !platform.isRoscomnadzored()))
                .sorted((o1, o2) -> o1.getAge() > o2.getAge() ? 1 : -1)
                .map(s -> s.getName())
                .findFirst();

        System.out.println(streamers_2.get());

//        3) Получить Map<Name(String), PlatfromName(String)> для всех стримеров

        Map<String, List<String>> streamers_3 = streamers.stream()
                .collect(Collectors.toMap(
                        s -> s.getName(),
                        s -> s.getPlatforms()
                                .stream()
                                .map(p -> p.getName())
                                .toList()
                ));

        System.out.println(streamers_3);

//        4) Найти стримера с наименишм количествои подписчиков, который работает на заблокированной платформе

        Optional<String> streamers_4 = streamers.stream()
                .filter(streamer -> streamer.getPlatforms()
                        .stream()
                        .allMatch(platform -> platform.isRoscomnadzored()))
                .sorted((o1, o2) -> o1.getSubscribers() > o2.getSubscribers() ? 1 : -1)
                .map(s -> s.getName())
                .findFirst();

        System.out.println(streamers_4.get());

//        5) Вычислить средний возраст стримеров на платформе twitch

        double streamers_5 = streamers.stream()
                .filter(s -> s.getPlatforms().contains((platforms.get(0))))
                .mapToDouble(s -> s.getAge())
                .average()
                .orElse(0.0);

        System.out.println(streamers_5);

//        6) Найти любого стримера на youtube с подсчиками > 10k. Если его нет - бросить NoSuchElementException

        Streamer any = streamers.stream()
                .filter(s -> s.getSubscribers() > 10_000)
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("no streamers :("));

//        7) *Получить из листа стримеров лист платформ (не должны повторяться платформы в выводном листе)

        List<String> platforms_1 = streamers.stream()
                .flatMap(s -> s.getPlatforms()
                        .stream())
                .map(s -> s.getName())
                .collect(Collectors.toSet())
                .stream().toList();

        System.out.println(platforms_1);
    }
}
