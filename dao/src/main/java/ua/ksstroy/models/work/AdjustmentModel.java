package ua.ksstroy.models.work;

import javax.persistence.*;

@Entity
@Table(name = "adjustments", catalog = "ksstroy")
public class AdjustmentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private String id;

    @Column(name = "value")
    private Double value;

    @Column(name = "is_absolute")
    private boolean isAbsolute;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "work_id")
    private WorkModel workModel;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public boolean isAbsolute() {
        return isAbsolute;
    }

    public void setAbsolute(boolean isAbsolute) {
        this.isAbsolute = isAbsolute;
    }

    public WorkModel getWorkModel() {
        return workModel;
    }

    public void setWorkModel(WorkModel workModel) {
        this.workModel = workModel;
    }
}
