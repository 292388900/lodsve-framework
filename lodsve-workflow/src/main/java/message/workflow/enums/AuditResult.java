package message.workflow.enums;

import message.base.bean.Codeable;

/**
 * .
 *
 * @author sunhao(sunhao.java@gmail.com)
 * @version V1.0, 2015-11-19 11:51
 */
public enum AuditResult implements Codeable {
    SUCCESS("100", "审核通过"), FAILURE("101", "审核失败");

    private String code;
    private String title;

    AuditResult(String code, String title) {
        this.code = code;
        this.title = title;
    }

    public String getCode() {
        return this.code;
    }

    @Override
    public String getTitle() {
        return title;
    }
}