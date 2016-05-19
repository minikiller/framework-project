package cn.com.vixo.standard;

/**
 * Created by zangyanming on 2016/3/25.
 */
public class StandardBean {
    /**
     * @describe 项目主键id
     * @validator 不能为空
     */
    private String projectId;
    /**
     * @describe 文件名
     * @validator 不能为空
     */
    private String fileName;
    /**
     * @describe 文件路径
     * @validator 不能为空
     */
    private String filePath;
    /**
     * @describe 文件描述
     */
    private String description;
    /**
     * @describe 文件大小
     */
    private String fileSize;
    /**
     * @describe 文件类型
     */
    private String fileType;
}
