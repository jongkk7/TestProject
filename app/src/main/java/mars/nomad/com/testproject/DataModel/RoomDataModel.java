package mars.nomad.com.testproject.DataModel;

/**
 * Created by YJK on 2019-04-29
 **/
public class RoomDataModel {

    private int seq;

    private String title;

    private String reader_id;

    private String start_time;

    private String end_time;

    private int type; // 0 : 관리자 승인 전, 1 : 관리자 승인, 모집중, 2 : 시작, 3 : 정상 완료, 4 : 비정상 완료

    private String category;

    private String roomImage;

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReader_id() {
        return reader_id;
    }

    public void setReader_id(String reader_id) {
        this.reader_id = reader_id;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "RoomDataModel{" +
                "seq=" + seq +
                ", title='" + title + '\'' +
                ", reader_id='" + reader_id + '\'' +
                ", start_time='" + start_time + '\'' +
                ", end_time='" + end_time + '\'' +
                ", type=" + type +
                ", category='" + category + '\'' +
                '}';
    }
}
