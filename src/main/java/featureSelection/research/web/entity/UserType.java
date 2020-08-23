package featureSelection.research.web.entity;

/**
 * @description: UserType
 * @date: 2020/8/22 22:41
 * @author: Stephen
 */
public enum UserType {
    admin("admin"), account("account");
    private String name;

    UserType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
