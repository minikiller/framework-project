/*
Navicat PGSQL Data Transfer

Source Server         : localhost
Source Server Version : 90404
Source Host           : localhost:5432
Source Database       : kalix
Source Schema         : public

Target Server Type    : PGSQL
Target Server Version : 90404
File Encoding         : 65001

Date: 2015-12-03 15:37:25
*/


-- ----------------------------
-- Sequence structure for act_evt_log_log_nr__seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."act_evt_log_log_nr__seq";
CREATE SEQUENCE "public"."act_evt_log_log_nr__seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Table structure for act_evt_log
-- ----------------------------
DROP TABLE IF EXISTS "public"."act_evt_log";
CREATE TABLE "public"."act_evt_log" (
"log_nr_" int4 DEFAULT nextval('act_evt_log_log_nr__seq'::regclass) NOT NULL,
"type_" varchar(64) COLLATE "default",
"proc_def_id_" varchar(64) COLLATE "default",
"proc_inst_id_" varchar(64) COLLATE "default",
"execution_id_" varchar(64) COLLATE "default",
"task_id_" varchar(64) COLLATE "default",
"time_stamp_" timestamp(6) NOT NULL,
"user_id_" varchar(255) COLLATE "default",
"data_" bytea,
"lock_owner_" varchar(255) COLLATE "default",
"lock_time_" timestamp(6),
"is_processed_" int2 DEFAULT 0
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of act_evt_log
-- ----------------------------

-- ----------------------------
-- Table structure for act_ge_bytearray
-- ----------------------------
DROP TABLE IF EXISTS "public"."act_ge_bytearray";
CREATE TABLE "public"."act_ge_bytearray" (
"id_" varchar(64) COLLATE "default" NOT NULL,
"rev_" int4,
"name_" varchar(255) COLLATE "default",
"deployment_id_" varchar(64) COLLATE "default",
"bytes_" bytea,
"generated_" bool
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of act_ge_bytearray
-- ----------------------------
INSERT INTO "public"."act_ge_bytearray" VALUES ('2', '1', 'OSGI-INF/activiti/notice.bpmn20.xml', '1', E'<?xml version="1.0" encoding="UTF-8"?>\\015\\012<definitions xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:activiti="http://activiti.org/bpmn"\\015\\012             xmlns:bpmndi="http://www.omg.org/spec/BPMN/20100524/DI"\\015\\012             xmlns:omgdc="http://www.omg.org/spec/DD/20100524/DC"\\015\\012             xmlns:omgdi="http://www.omg.org/spec/DD/20100524/DI" xmlns="http://www.omg.org/spec/BPMN/20100524/MODEL"\\015\\012             typeLanguage="http://www.w3.org/2001/XMLSchema" expressionLanguage="http://www.w3.org/1999/XPath"\\015\\012             targetNamespace="http://www.activiti.org/test">\\015\\012    <process id="fireworks" name="\\347\\203\\237\\350\\212\\261\\347\\210\\206\\347\\253\\271\\347\\273\\217\\350\\220\\245\\350\\256\\270\\345\\217\\257\\350\\257\\201" isExecutable="true">\\015\\012        <documentation>\\347\\203\\237\\350\\212\\261\\347\\210\\206\\347\\253\\271\\347\\273\\217\\350\\220\\245\\350\\256\\270\\345\\217\\257\\350\\257\\201\\346\\265\\201\\347\\250\\213</documentation>\\015\\012        <startEvent id="startevent1" name="Start" activiti:formKey="start.form"></startEvent>\\015\\012        <userTask id="usertask2" name="\\347\\254\\246\\345\\220\\210\\346\\200\\247\\345\\256\\241\\346\\211\\271" activiti:assignee="qwer" activiti:formKey="audit.form">\\015\\012            <documentation>\\015\\012                \\347\\203\\237\\350\\212\\261\\347\\210\\206\\347\\253\\271\\347\\273\\217\\350\\220\\245\\350\\256\\270\\345\\217\\257\\350\\257\\201\\346\\265\\201\\347\\250\\213\\015\\012            </documentation>\\015\\012            <extensionElements>\\015\\012                <activiti:formProperty id="accepted" name="\\345\\210\\244\\346\\226\\255\\347\\216\\257\\350\\212\\202" variable="accepted"\\015\\012                                       type="boolean"></activiti:formProperty>\\015\\012            </extensionElements>\\015\\012        </userTask>\\015\\012        <exclusiveGateway id="exclusivegateway1" name="Exclusive Gateway"></exclusiveGateway>\\015\\012        <sequenceFlow id="flow3" sourceRef="usertask2" targetRef="exclusivegateway1"></sequenceFlow>\\015\\012        <userTask id="usertask3" name="\\347\\216\\260\\345\\234\\272\\345\\244\\215\\346\\240\\270\\345\\256\\241\\346\\211\\271" activiti:assignee="qwer" activiti:formKey="audit.form">\\015\\012            <documentation>\\015\\012                \\347\\203\\237\\350\\212\\261\\347\\210\\206\\347\\253\\271\\347\\273\\217\\350\\220\\245\\350\\256\\270\\345\\217\\257\\350\\257\\201\\346\\265\\201\\347\\250\\213\\015\\012            </documentation>\\015\\012            <extensionElements>\\015\\012                <activiti:formProperty id="accepted" name="\\345\\210\\244\\346\\226\\255\\347\\216\\257\\350\\212\\202" variable="accepted"\\015\\012                                       type="boolean"></activiti:formProperty>\\015\\012            </extensionElements>\\015\\012            <!--<humanPerformer>\\015\\012                <resourceAssignmentExpression>\\015\\012                    <formalExpression>${assignee}</formalExpression>\\015\\012                </resourceAssignmentExpression>\\015\\012            </humanPerformer>\\015\\012            <multiInstanceLoopCharacteristics isSequential="false">\\015\\012                <loopDataInputRef>assigneeList</loopDataInputRef>\\015\\012                <inputDataItem name="assignee"></inputDataItem>\\015\\012                <completionCondition>${nrOfCompletedInstances/nrOfInstances == 1}</completionCondition>\\015\\012            </multiInstanceLoopCharacteristics>-->\\015\\012        </userTask>\\015\\012        <sequenceFlow id="flow4" name="\\345\\220\\214\\346\\204\\217" sourceRef="exclusivegateway1" targetRef="usertask3">\\015\\012            <conditionExpression xsi:type="tFormalExpression"><![CDATA[${accepted}]]></conditionExpression>\\015\\012        </sequenceFlow>\\015\\012        <exclusiveGateway id="exclusivegateway2" name="Exclusive Gateway"></exclusiveGateway>\\015\\012        <sequenceFlow id="flow5" sourceRef="usertask3" targetRef="exclusivegateway2"></sequenceFlow>\\015\\012        <userTask id="usertask4" name="\\345\\256\\241\\346\\211\\271\\345\\247\\224\\345\\221\\230\\344\\274\\232\\344\\274\\232\\347\\255\\276" activiti:assignee="qwer" activiti:formKey="audit.form">\\015\\012            <documentation>\\015\\012                \\347\\203\\237\\350\\212\\261\\347\\210\\206\\347\\253\\271\\347\\273\\217\\350\\220\\245\\350\\256\\270\\345\\217\\257\\350\\257\\201\\346\\265\\201\\347\\250\\213\\015\\012            </documentation>\\015\\012            <extensionElements>\\015\\012                <activiti:formProperty id="accepted" name="\\345\\210\\244\\346\\226\\255\\347\\216\\257\\350\\212\\202" variable="accepted"\\015\\012                                       type="boolean"></activiti:formProperty>\\015\\012            </extensionElements>\\015\\012        </userTask>\\015\\012        <sequenceFlow id="flow6" name="\\345\\220\\214\\346\\204\\217" sourceRef="exclusivegateway2" targetRef="usertask4">\\015\\012            <conditionExpression xsi:type="tFormalExpression"><![CDATA[${accepted}]]></conditionExpression>\\015\\012        </sequenceFlow>\\015\\012        <exclusiveGateway id="exclusivegateway3" name="Exclusive Gateway"></exclusiveGateway>\\015\\012        <sequenceFlow id="flow7" sourceRef="usertask4" targetRef="exclusivegateway3"></sequenceFlow>\\015\\012        <userTask id="usertask5" name="\\345\\261\\200\\351\\225\\277\\345\\256\\241\\346\\211\\271" activiti:assignee="qwer" activiti:formKey="audit.form">\\015\\012            <documentation>\\015\\012                \\347\\203\\237\\350\\212\\261\\347\\210\\206\\347\\253\\271\\347\\273\\217\\350\\220\\245\\350\\256\\270\\345\\217\\257\\350\\257\\201\\346\\265\\201\\347\\250\\213\\015\\012            </documentation>\\015\\012            <extensionElements>\\015\\012                <activiti:formProperty id="accepted" name="\\345\\210\\244\\346\\226\\255\\347\\216\\257\\350\\212\\202" variable="accepted"\\015\\012                                       type="boolean"></activiti:formProperty>\\015\\012            </extensionElements>\\015\\012        </userTask>\\015\\012        <sequenceFlow id="flow8" name="\\345\\220\\214\\346\\204\\217" sourceRef="exclusivegateway3" targetRef="usertask5">\\015\\012            <conditionExpression xsi:type="tFormalExpression"><![CDATA[${accepted}]]></conditionExpression>\\015\\012        </sequenceFlow>\\015\\012        <exclusiveGateway id="exclusivegateway4" name="Exclusive Gateway"></exclusiveGateway>\\015\\012        <sequenceFlow id="flow9" sourceRef="usertask5" targetRef="exclusivegateway4"></sequenceFlow>\\015\\012        <userTask id="usertask6" name="\\351\\242\\201\\345\\217\\221\\350\\257\\201\\344\\273\\266" activiti:assignee="qwer" activiti:formKey="end.form">\\015\\012            <documentation>\\015\\012                \\347\\203\\237\\350\\212\\261\\347\\210\\206\\347\\253\\271\\347\\273\\217\\350\\220\\245\\350\\256\\270\\345\\217\\257\\350\\257\\201\\346\\265\\201\\347\\250\\213\\015\\012            </documentation>\\015\\012            <extensionElements>\\015\\012                <activiti:formProperty id="name" name="\\345\\215\\225\\344\\275\\215\\345\\220\\215\\347\\247\\260"></activiti:formProperty>\\015\\012                <activiti:formProperty id="head" name="\\344\\270\\273\\350\\246\\201\\350\\264\\237\\350\\264\\243\\344\\272\\272"></activiti:formProperty>\\015\\012                <activiti:formProperty id="phone" name="\\350\\264\\237\\350\\264\\243\\344\\272\\272\\347\\224\\265\\350\\257\\235"></activiti:formProperty>\\015\\012                <activiti:formProperty id="address" name="\\346\\263\\250\\345\\206\\214\\345\\234\\260\\345\\235\\200"></activiti:formProperty>\\015\\012                <activiti:formProperty id="economicsType" name="\\347\\273\\217\\346\\265\\216\\347\\261\\273\\345\\236\\213"></activiti:formProperty>\\015\\012                <activiti:formProperty id="storageAddress" name="\\344\\273\\223\\345\\202\\250\\350\\256\\276\\346\\226\\275\\345\\234\\260\\345\\235\\200"></activiti:formProperty>\\015\\012                <activiti:formProperty id="scope" name="\\350\\256\\270\\345\\217\\257\\347\\273\\217\\350\\220\\245\\350\\214\\203\\345\\233\\264"></activiti:formProperty>\\015\\012                <activiti:formProperty id="code" name="\\347\\231\\273\\350\\256\\260\\347\\274\\226\\345\\217\\267"></activiti:formProperty>\\015\\012                <activiti:formProperty id="card" name="FM\\345\\256\\211\\350\\256\\270\\350\\257\\201\\345\\255\\227"></activiti:formProperty>\\015\\012                <activiti:formProperty id="validityDate" name="\\346\\234\\211\\346\\225\\210\\346\\234\\237"></activiti:formProperty>\\015\\012                <activiti:formProperty id="unitsDate" name="\\345\\217\\221\\350\\257\\201\\346\\234\\272\\345\\205\\263"></activiti:formProperty>\\015\\012                <activiti:formProperty id="linkHandle" name="\\345\\275\\223\\345\\211\\215\\345\\212\\236\\347\\220\\206\\347\\216\\257\\350\\212\\202"></activiti:formProperty>\\015\\012                <activiti:formProperty id="proposerId" name="\\345\\256\\241\\350\\257\\267\\344\\272\\272ID"></activiti:formProperty>\\015\\012                <activiti:formProperty id="enterpriseId" name="\\344\\274\\201\\344\\270\\232ID"></activiti:formProperty>\\015\\012            </extensionElements>\\015\\012        </userTask>\\015\\012        <sequenceFlow id="flow10" name="\\345\\220\\214\\346\\204\\217" sourceRef="exclusivegateway4" targetRef="usertask6">\\015\\012            <conditionExpression xsi:type="tFormalExpression"><![CDATA[${accepted}]]></conditionExpression>\\015\\012        </sequenceFlow>\\015\\012        <endEvent id="endevent1" name="End"></endEvent>\\015\\012        <sequenceFlow id="flow11" sourceRef="usertask6" targetRef="endevent1"></sequenceFlow>\\015\\012        <userTask id="usertask7" name="\\345\\256\\241\\346\\211\\271\\344\\277\\256\\346\\224\\271" activiti:formKey="modify.form">\\015\\012            <extensionElements>\\015\\012                <activiti:formProperty id="name" name="\\345\\215\\225\\344\\275\\215\\345\\220\\215\\347\\247\\260"></activiti:formProperty>\\015\\012                <activiti:formProperty id="head" name="\\344\\270\\273\\350\\246\\201\\350\\264\\237\\350\\264\\243\\344\\272\\272"></activiti:formProperty>\\015\\012                <activiti:formProperty id="phone" name="\\350\\264\\237\\350\\264\\243\\344\\272\\272\\347\\224\\265\\350\\257\\235"></activiti:formProperty>\\015\\012                <activiti:formProperty id="address" name="\\346\\263\\250\\345\\206\\214\\345\\234\\260\\345\\235\\200"></activiti:formProperty>\\015\\012                <activiti:formProperty id="economicsType" name="\\347\\273\\217\\346\\265\\216\\347\\261\\273\\345\\236\\213"></activiti:formProperty>\\015\\012                <activiti:formProperty id="storageAddress" name="\\344\\273\\223\\345\\202\\250\\350\\256\\276\\346\\226\\275\\345\\234\\260\\345\\235\\200"></activiti:formProperty>\\015\\012                <activiti:formProperty id="scope" name="\\350\\256\\270\\345\\217\\257\\347\\273\\217\\350\\220\\245\\350\\214\\203\\345\\233\\264"></activiti:formProperty>\\015\\012                <activiti:formProperty id="code" name="\\347\\231\\273\\350\\256\\260\\347\\274\\226\\345\\217\\267"></activiti:formProperty>\\015\\012                <activiti:formProperty id="card" name="FM\\345\\256\\211\\350\\256\\270\\350\\257\\201\\345\\255\\227"></activiti:formProperty>\\015\\012                <activiti:formProperty id="validityDate" name="\\346\\234\\211\\346\\225\\210\\346\\234\\237"></activiti:formProperty>\\015\\012                <activiti:formProperty id="unitsDate" name="\\345\\217\\221\\350\\257\\201\\346\\234\\272\\345\\205\\263"></activiti:formProperty>\\015\\012                <activiti:formProperty id="linkHandle" name="\\345\\275\\223\\345\\211\\215\\345\\212\\236\\347\\220\\206\\347\\216\\257\\350\\212\\202"></activiti:formProperty>\\015\\012                <activiti:formProperty id="proposerId" name="\\345\\256\\241\\350\\257\\267\\344\\272\\272ID"></activiti:formProperty>\\015\\012                <activiti:formProperty id="enterpriseId" name="\\344\\274\\201\\344\\270\\232ID"></activiti:formProperty>\\015\\012            </extensionElements>\\015\\012            <humanPerformer>\\015\\012                <resourceAssignmentExpression>\\015\\012                    <formalExpression>${assignee}</formalExpression>\\015\\012                </resourceAssignmentExpression>\\015\\012            </humanPerformer>\\015\\012        </userTask>\\015\\012        <sequenceFlow id="flow16" sourceRef="usertask7" targetRef="usertask2"></sequenceFlow>\\015\\012        <sequenceFlow id="flow12" name="\\344\\270\\215\\345\\220\\214\\346\\204\\217" sourceRef="exclusivegateway4" targetRef="usertask7">\\015\\012            <conditionExpression xsi:type="tFormalExpression"><![CDATA[${!accepted}]]></conditionExpression>\\015\\012        </sequenceFlow>\\015\\012        <sequenceFlow id="flow13" name="\\344\\270\\215\\345\\220\\214\\346\\204\\217" sourceRef="exclusivegateway3" targetRef="usertask7">\\015\\012            <conditionExpression xsi:type="tFormalExpression"><![CDATA[${!accepted}]]></conditionExpression>\\015\\012        </sequenceFlow>\\015\\012        <sequenceFlow id="flow14" name="\\344\\270\\215\\345\\220\\214\\346\\204\\217" sourceRef="exclusivegateway2" targetRef="usertask7">\\015\\012            <conditionExpression xsi:type="tFormalExpression"><![CDATA[${!accepted}]]></conditionExpression>\\015\\012        </sequenceFlow>\\015\\012        <sequenceFlow id="flow15" name="\\344\\270\\215\\345\\220\\214\\346\\204\\217" sourceRef="exclusivegateway1" targetRef="usertask7">\\015\\012            <conditionExpression xsi:type="tFormalExpression"><![CDATA[${!accepted}]]></conditionExpression>\\015\\012        </sequenceFlow>\\015\\012        <sequenceFlow id="flow17" sourceRef="startevent1" targetRef="usertask2"></sequenceFlow>\\015\\012    </process>\\015\\012    <bpmndi:BPMNDiagram id="BPMNDiagram_fireworks">\\015\\012        <bpmndi:BPMNPlane bpmnElement="fireworks" id="BPMNPlane_fireworks">\\015\\012            <bpmndi:BPMNShape bpmnElement="startevent1" id="BPMNShape_startevent1">\\015\\012                <omgdc:Bounds height="35.0" width="35.0" x="240.0" y="164.0"></omgdc:Bounds>\\015\\012            </bpmndi:BPMNShape>\\015\\012            <bpmndi:BPMNShape bpmnElement="usertask2" id="BPMNShape_usertask2">\\015\\012                <omgdc:Bounds height="55.0" width="105.0" x="320.0" y="155.0"></omgdc:Bounds>\\015\\012            </bpmndi:BPMNShape>\\015\\012            <bpmndi:BPMNShape bpmnElement="exclusivegateway1" id="BPMNShape_exclusivegateway1">\\015\\012                <omgdc:Bounds height="40.0" width="40.0" x="450.0" y="164.0"></omgdc:Bounds>\\015\\012            </bpmndi:BPMNShape>\\015\\012            <bpmndi:BPMNShape bpmnElement="usertask3" id="BPMNShape_usertask3">\\015\\012                <omgdc:Bounds height="55.0" width="105.0" x="530.0" y="156.0"></omgdc:Bounds>\\015\\012            </bpmndi:BPMNShape>\\015\\012            <bpmndi:BPMNShape bpmnElement="exclusivegateway2" id="BPMNShape_exclusivegateway2">\\015\\012                <omgdc:Bounds height="40.0" width="40.0" x="660.0" y="162.0"></omgdc:Bounds>\\015\\012            </bpmndi:BPMNShape>\\015\\012            <bpmndi:BPMNShape bpmnElement="usertask4" id="BPMNShape_usertask4">\\015\\012                <omgdc:Bounds height="55.0" width="105.0" x="740.0" y="154.0"></omgdc:Bounds>\\015\\012            </bpmndi:BPMNShape>\\015\\012            <bpmndi:BPMNShape bpmnElement="exclusivegateway3" id="BPMNShape_exclusivegateway3">\\015\\012                <omgdc:Bounds height="40.0" width="40.0" x="870.0" y="163.0"></omgdc:Bounds>\\015\\012            </bpmndi:BPMNShape>\\015\\012            <bpmndi:BPMNShape bpmnElement="usertask5" id="BPMNShape_usertask5">\\015\\012                <omgdc:Bounds height="55.0" width="105.0" x="950.0" y="154.0"></omgdc:Bounds>\\015\\012            </bpmndi:BPMNShape>\\015\\012            <bpmndi:BPMNShape bpmnElement="exclusivegateway4" id="BPMNShape_exclusivegateway4">\\015\\012                <omgdc:Bounds height="40.0" width="40.0" x="1090.0" y="161.0"></omgdc:Bounds>\\015\\012            </bpmndi:BPMNShape>\\015\\012            <bpmndi:BPMNShape bpmnElement="usertask6" id="BPMNShape_usertask6">\\015\\012                <omgdc:Bounds height="55.0" width="105.0" x="1170.0" y="154.0"></omgdc:Bounds>\\015\\012            </bpmndi:BPMNShape>\\015\\012            <bpmndi:BPMNShape bpmnElement="endevent1" id="BPMNShape_endevent1">\\015\\012                <omgdc:Bounds height="35.0" width="35.0" x="1310.0" y="165.0"></omgdc:Bounds>\\015\\012            </bpmndi:BPMNShape>\\015\\012            <bpmndi:BPMNShape bpmnElement="usertask7" id="BPMNShape_usertask7">\\015\\012                <omgdc:Bounds height="55.0" width="105.0" x="320.0" y="250.0"></omgdc:Bounds>\\015\\012            </bpmndi:BPMNShape>\\015\\012            <bpmndi:BPMNEdge bpmnElement="flow3" id="BPMNEdge_flow3">\\015\\012                <omgdi:waypoint x="425.0" y="182.0"></omgdi:waypoint>\\015\\012                <omgdi:waypoint x="450.0" y="184.0"></omgdi:waypoint>\\015\\012            </bpmndi:BPMNEdge>\\015\\012            <bpmndi:BPMNEdge bpmnElement="flow4" id="BPMNEdge_flow4">\\015\\012                <omgdi:waypoint x="490.0" y="184.0"></omgdi:waypoint>\\015\\012                <omgdi:waypoint x="530.0" y="183.0"></omgdi:waypoint>\\015\\012                <bpmndi:BPMNLabel>\\015\\012                    <omgdc:Bounds height="14.0" width="24.0" x="489.0" y="165.0"></omgdc:Bounds>\\015\\012                </bpmndi:BPMNLabel>\\015\\012            </bpmndi:BPMNEdge>\\015\\012            <bpmndi:BPMNEdge bpmnElement="flow5" id="BPMNEdge_flow5">\\015\\012                <omgdi:waypoint x="635.0" y="183.0"></omgdi:waypoint>\\015\\012                <omgdi:waypoint x="660.0" y="182.0"></omgdi:waypoint>\\015\\012            </bpmndi:BPMNEdge>\\015\\012            <bpmndi:BPMNEdge bpmnElement="flow6" id="BPMNEdge_flow6">\\015\\012                <omgdi:waypoint x="700.0" y="182.0"></omgdi:waypoint>\\015\\012                <omgdi:waypoint x="740.0" y="181.0"></omgdi:waypoint>\\015\\012                <bpmndi:BPMNLabel>\\015\\012                    <omgdc:Bounds height="14.0" width="24.0" x="699.0" y="165.0"></omgdc:Bounds>\\015\\012                </bpmndi:BPMNLabel>\\015\\012            </bpmndi:BPMNEdge>\\015\\012            <bpmndi:BPMNEdge bpmnElement="flow7" id="BPMNEdge_flow7">\\015\\012                <omgdi:waypoint x="845.0" y="181.0"></omgdi:waypoint>\\015\\012                <omgdi:waypoint x="870.0" y="183.0"></omgdi:waypoint>\\015\\012            </bpmndi:BPMNEdge>\\015\\012            <bpmndi:BPMNEdge bpmnElement="flow8" id="BPMNEdge_flow8">\\015\\012                <omgdi:waypoint x="910.0" y="183.0"></omgdi:waypoint>\\015\\012                <omgdi:waypoint x="950.0" y="181.0"></omgdi:waypoint>\\015\\012                <bpmndi:BPMNLabel>\\015\\012                    <omgdc:Bounds height="14.0" width="24.0" x="909.0" y="165.0"></omgdc:Bounds>\\015\\012                </bpmndi:BPMNLabel>\\015\\012            </bpmndi:BPMNEdge>\\015\\012            <bpmndi:BPMNEdge bpmnElement="flow9" id="BPMNEdge_flow9">\\015\\012                <omgdi:waypoint x="1055.0" y="181.0"></omgdi:waypoint>\\015\\012                <omgdi:waypoint x="1090.0" y="181.0"></omgdi:waypoint>\\015\\012            </bpmndi:BPMNEdge>\\015\\012            <bpmndi:BPMNEdge bpmnElement="flow10" id="BPMNEdge_flow10">\\015\\012                <omgdi:waypoint x="1130.0" y="181.0"></omgdi:waypoint>\\015\\012                <omgdi:waypoint x="1170.0" y="181.0"></omgdi:waypoint>\\015\\012                <bpmndi:BPMNLabel>\\015\\012                    <omgdc:Bounds height="14.0" width="24.0" x="1129.0" y="164.0"></omgdc:Bounds>\\015\\012                </bpmndi:BPMNLabel>\\015\\012            </bpmndi:BPMNEdge>\\015\\012            <bpmndi:BPMNEdge bpmnElement="flow11" id="BPMNEdge_flow11">\\015\\012                <omgdi:waypoint x="1275.0" y="181.0"></omgdi:waypoint>\\015\\012                <omgdi:waypoint x="1310.0" y="182.0"></omgdi:waypoint>\\015\\012            </bpmndi:BPMNEdge>\\015\\012            <bpmndi:BPMNEdge bpmnElement="flow16" id="BPMNEdge_flow16">\\015\\012                <omgdi:waypoint x="372.0" y="250.0"></omgdi:waypoint>\\015\\012                <omgdi:waypoint x="372.0" y="210.0"></omgdi:waypoint>\\015\\012            </bpmndi:BPMNEdge>\\015\\012            <bpmndi:BPMNEdge bpmnElement="flow12" id="BPMNEdge_flow12">\\015\\012                <omgdi:waypoint x="1110.0" y="201.0"></omgdi:waypoint>\\015\\012                <omgdi:waypoint x="1109.0" y="277.0"></omgdi:waypoint>\\015\\012                <omgdi:waypoint x="425.0" y="277.0"></omgdi:waypoint>\\015\\012                <bpmndi:BPMNLabel>\\015\\012                    <omgdc:Bounds height="14.0" width="36.0" x="1093.0" y="229.0"></omgdc:Bounds>\\015\\012                </bpmndi:BPMNLabel>\\015\\012            </bpmndi:BPMNEdge>\\015\\012            <bpmndi:BPMNEdge bpmnElement="flow13" id="BPMNEdge_flow13">\\015\\012                <omgdi:waypoint x="890.0" y="203.0"></omgdi:waypoint>\\015\\012                <omgdi:waypoint x="889.0" y="277.0"></omgdi:waypoint>\\015\\012                <omgdi:waypoint x="425.0" y="277.0"></omgdi:waypoint>\\015\\012                <bpmndi:BPMNLabel>\\015\\012                    <omgdc:Bounds height="14.0" width="36.0" x="873.0" y="229.0"></omgdc:Bounds>\\015\\012                </bpmndi:BPMNLabel>\\015\\012            </bpmndi:BPMNEdge>\\015\\012            <bpmndi:BPMNEdge bpmnElement="flow14" id="BPMNEdge_flow14">\\015\\012                <omgdi:waypoint x="680.0" y="202.0"></omgdi:waypoint>\\015\\012                <omgdi:waypoint x="679.0" y="277.0"></omgdi:waypoint>\\015\\012                <omgdi:waypoint x="425.0" y="277.0"></omgdi:waypoint>\\015\\012                <bpmndi:BPMNLabel>\\015\\012                    <omgdc:Bounds height="14.0" width="36.0" x="663.0" y="229.0"></omgdc:Bounds>\\015\\012                </bpmndi:BPMNLabel>\\015\\012            </bpmndi:BPMNEdge>\\015\\012            <bpmndi:BPMNEdge bpmnElement="flow15" id="BPMNEdge_flow15">\\015\\012                <omgdi:waypoint x="470.0" y="204.0"></omgdi:waypoint>\\015\\012                <omgdi:waypoint x="470.0" y="277.0"></omgdi:waypoint>\\015\\012                <omgdi:waypoint x="425.0" y="277.0"></omgdi:waypoint>\\015\\012                <bpmndi:BPMNLabel>\\015\\012                    <omgdc:Bounds height="14.0" width="36.0" x="452.0" y="229.0"></omgdc:Bounds>\\015\\012                </bpmndi:BPMNLabel>\\015\\012            </bpmndi:BPMNEdge>\\015\\012            <bpmndi:BPMNEdge bpmnElement="flow17" id="BPMNEdge_flow17">\\015\\012                <omgdi:waypoint x="275.0" y="181.0"></omgdi:waypoint>\\015\\012                <omgdi:waypoint x="320.0" y="182.0"></omgdi:waypoint>\\015\\012            </bpmndi:BPMNEdge>\\015\\012        </bpmndi:BPMNPlane>\\015\\012    </bpmndi:BPMNDiagram>\\015\\012</definitions>\\015\\012', 'f');

-- ----------------------------
-- Table structure for act_ge_property
-- ----------------------------
DROP TABLE IF EXISTS "public"."act_ge_property";
CREATE TABLE "public"."act_ge_property" (
"name_" varchar(64) COLLATE "default" NOT NULL,
"value_" varchar(300) COLLATE "default",
"rev_" int4
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of act_ge_property
-- ----------------------------
INSERT INTO "public"."act_ge_property" VALUES ('next.dbid', '15001', '7');
INSERT INTO "public"."act_ge_property" VALUES ('schema.history', 'create(5.17.0.2) upgrade(5.17.0.2->5.18.0.0)', '2');
INSERT INTO "public"."act_ge_property" VALUES ('schema.version', '5.18.0.0', '2');

-- ----------------------------
-- Table structure for act_hi_actinst
-- ----------------------------
DROP TABLE IF EXISTS "public"."act_hi_actinst";
CREATE TABLE "public"."act_hi_actinst" (
"id_" varchar(64) COLLATE "default" NOT NULL,
"proc_def_id_" varchar(64) COLLATE "default" NOT NULL,
"proc_inst_id_" varchar(64) COLLATE "default" NOT NULL,
"execution_id_" varchar(64) COLLATE "default" NOT NULL,
"act_id_" varchar(255) COLLATE "default" NOT NULL,
"task_id_" varchar(64) COLLATE "default",
"call_proc_inst_id_" varchar(64) COLLATE "default",
"act_name_" varchar(255) COLLATE "default",
"act_type_" varchar(255) COLLATE "default" NOT NULL,
"assignee_" varchar(255) COLLATE "default",
"start_time_" timestamp(6) NOT NULL,
"end_time_" timestamp(6),
"duration_" int8,
"tenant_id_" varchar(255) COLLATE "default" DEFAULT ''::character varying
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of act_hi_actinst
-- ----------------------------
INSERT INTO "public"."act_hi_actinst" VALUES ('10004', 'fireworks:1:3', '7501', '7501', 'exclusivegateway1', null, null, 'Exclusive Gateway', 'exclusiveGateway', null, '2015-11-10 19:47:11.627', '2015-11-10 19:47:11.628', '1', '');
INSERT INTO "public"."act_hi_actinst" VALUES ('10005', 'fireworks:1:3', '7501', '7501', 'usertask3', '10006', null, '现场复核审批', 'userTask', 'qwer', '2015-11-10 19:47:11.628', '2015-11-10 19:52:59.049', '347421', '');
INSERT INTO "public"."act_hi_actinst" VALUES ('10009', 'fireworks:1:3', '7501', '7501', 'exclusivegateway2', null, null, 'Exclusive Gateway', 'exclusiveGateway', null, '2015-11-10 19:52:59.049', '2015-11-10 19:52:59.049', '0', '');
INSERT INTO "public"."act_hi_actinst" VALUES ('10010', 'fireworks:1:3', '7501', '7501', 'usertask4', '10011', null, '审批委员会会签', 'userTask', 'qwer', '2015-11-10 19:52:59.049', '2015-11-10 19:53:25.96', '26911', '');
INSERT INTO "public"."act_hi_actinst" VALUES ('10014', 'fireworks:1:3', '7501', '7501', 'exclusivegateway3', null, null, 'Exclusive Gateway', 'exclusiveGateway', null, '2015-11-10 19:53:25.96', '2015-11-10 19:53:25.96', '0', '');
INSERT INTO "public"."act_hi_actinst" VALUES ('10015', 'fireworks:1:3', '7501', '7501', 'usertask5', '10016', null, '局长审批', 'userTask', 'qwer', '2015-11-10 19:53:25.96', null, null, '');
INSERT INTO "public"."act_hi_actinst" VALUES ('12503', 'fireworks:1:3', '12501', '12501', 'startevent1', null, null, 'Start', 'startEvent', null, '2015-11-28 21:42:48.153', '2015-11-28 21:42:48.16', '7', '');
INSERT INTO "public"."act_hi_actinst" VALUES ('12504', 'fireworks:1:3', '12501', '12501', 'usertask2', '12505', null, '符合性审批', 'userTask', 'qwer', '2015-11-28 21:42:48.161', null, null, '');
INSERT INTO "public"."act_hi_actinst" VALUES ('2503', 'fireworks:1:3', '2501', '2501', 'startevent1', null, null, 'Start', 'startEvent', null, '2015-09-10 17:39:48.195', '2015-09-10 17:39:48.206', '11', '');
INSERT INTO "public"."act_hi_actinst" VALUES ('2504', 'fireworks:1:3', '2501', '2501', 'usertask2', '2505', null, '符合性审批', 'userTask', 'qwer', '2015-09-10 17:39:48.207', '2015-09-10 21:47:42.538', '14874331', '');
INSERT INTO "public"."act_hi_actinst" VALUES ('5004', 'fireworks:1:3', '2501', '2501', 'exclusivegateway1', null, null, 'Exclusive Gateway', 'exclusiveGateway', null, '2015-09-10 21:47:42.538', '2015-09-10 21:47:42.539', '1', '');
INSERT INTO "public"."act_hi_actinst" VALUES ('5005', 'fireworks:1:3', '2501', '2501', 'usertask3', '5006', null, '现场复核审批', 'userTask', 'qwer', '2015-09-10 21:47:42.539', null, null, '');
INSERT INTO "public"."act_hi_actinst" VALUES ('7503', 'fireworks:1:3', '7501', '7501', 'startevent1', null, null, 'Start', 'startEvent', null, '2015-11-09 20:54:28.103', '2015-11-09 20:54:28.111', '8', '');
INSERT INTO "public"."act_hi_actinst" VALUES ('7504', 'fireworks:1:3', '7501', '7501', 'usertask2', '7505', null, '符合性审批', 'userTask', 'qwer', '2015-11-09 20:54:28.111', '2015-11-10 19:47:11.626', '82363515', '');

-- ----------------------------
-- Table structure for act_hi_attachment
-- ----------------------------
DROP TABLE IF EXISTS "public"."act_hi_attachment";
CREATE TABLE "public"."act_hi_attachment" (
"id_" varchar(64) COLLATE "default" NOT NULL,
"rev_" int4,
"user_id_" varchar(255) COLLATE "default",
"name_" varchar(255) COLLATE "default",
"description_" varchar(4000) COLLATE "default",
"type_" varchar(255) COLLATE "default",
"task_id_" varchar(64) COLLATE "default",
"proc_inst_id_" varchar(64) COLLATE "default",
"url_" varchar(4000) COLLATE "default",
"content_id_" varchar(64) COLLATE "default",
"time_" timestamp(6)
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of act_hi_attachment
-- ----------------------------

-- ----------------------------
-- Table structure for act_hi_comment
-- ----------------------------
DROP TABLE IF EXISTS "public"."act_hi_comment";
CREATE TABLE "public"."act_hi_comment" (
"id_" varchar(64) COLLATE "default" NOT NULL,
"type_" varchar(255) COLLATE "default",
"time_" timestamp(6) NOT NULL,
"user_id_" varchar(255) COLLATE "default",
"task_id_" varchar(64) COLLATE "default",
"proc_inst_id_" varchar(64) COLLATE "default",
"action_" varchar(255) COLLATE "default",
"message_" varchar(4000) COLLATE "default",
"full_msg_" bytea
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of act_hi_comment
-- ----------------------------
INSERT INTO "public"."act_hi_comment" VALUES ('10001', 'comment', '2015-11-10 19:47:11.472', 'qwer', '7505', '7501', 'AddComment', 'sdfdff', E'sdfdff');
INSERT INTO "public"."act_hi_comment" VALUES ('10007', 'comment', '2015-11-10 19:52:59.037', 'qwer', '10006', '7501', 'AddComment', 'sdsd', E'sdsd');
INSERT INTO "public"."act_hi_comment" VALUES ('10012', 'comment', '2015-11-10 19:53:25.948', 'qwer', '10011', '7501', 'AddComment', 'sdsd', E'sdsd');
INSERT INTO "public"."act_hi_comment" VALUES ('5001', 'comment', '2015-09-10 21:47:42.354', 'qwer', '2505', '2501', 'AddComment', 'sdsf', E'sdsf');

-- ----------------------------
-- Table structure for act_hi_detail
-- ----------------------------
DROP TABLE IF EXISTS "public"."act_hi_detail";
CREATE TABLE "public"."act_hi_detail" (
"id_" varchar(64) COLLATE "default" NOT NULL,
"type_" varchar(255) COLLATE "default" NOT NULL,
"proc_inst_id_" varchar(64) COLLATE "default",
"execution_id_" varchar(64) COLLATE "default",
"task_id_" varchar(64) COLLATE "default",
"act_inst_id_" varchar(64) COLLATE "default",
"name_" varchar(255) COLLATE "default" NOT NULL,
"var_type_" varchar(64) COLLATE "default",
"rev_" int4,
"time_" timestamp(6) NOT NULL,
"bytearray_id_" varchar(64) COLLATE "default",
"double_" float8,
"long_" int8,
"text_" varchar(4000) COLLATE "default",
"text2_" varchar(4000) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of act_hi_detail
-- ----------------------------
INSERT INTO "public"."act_hi_detail" VALUES ('10003', 'VariableUpdate', '7501', '7501', null, '7504', 'accepted', 'boolean', '0', '2015-11-10 19:47:11.588', null, null, '1', null, null);
INSERT INTO "public"."act_hi_detail" VALUES ('10008', 'VariableUpdate', '7501', '7501', null, '10005', 'accepted', 'boolean', '1', '2015-11-10 19:52:59.041', null, null, '1', null, null);
INSERT INTO "public"."act_hi_detail" VALUES ('10013', 'VariableUpdate', '7501', '7501', null, '10010', 'accepted', 'boolean', '1', '2015-11-10 19:53:25.952', null, null, '1', null, null);
INSERT INTO "public"."act_hi_detail" VALUES ('5003', 'VariableUpdate', '2501', '2501', null, '2504', 'accepted', 'boolean', '0', '2015-09-10 21:47:42.515', null, null, '1', null, null);

-- ----------------------------
-- Table structure for act_hi_identitylink
-- ----------------------------
DROP TABLE IF EXISTS "public"."act_hi_identitylink";
CREATE TABLE "public"."act_hi_identitylink" (
"id_" varchar(64) COLLATE "default" NOT NULL,
"group_id_" varchar(255) COLLATE "default",
"type_" varchar(255) COLLATE "default",
"user_id_" varchar(255) COLLATE "default",
"task_id_" varchar(64) COLLATE "default",
"proc_inst_id_" varchar(64) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of act_hi_identitylink
-- ----------------------------
INSERT INTO "public"."act_hi_identitylink" VALUES ('12502', null, 'starter', 'admin', null, '12501');
INSERT INTO "public"."act_hi_identitylink" VALUES ('12506', null, 'participant', 'qwer', null, '12501');
INSERT INTO "public"."act_hi_identitylink" VALUES ('2502', null, 'starter', 'admin', null, '2501');
INSERT INTO "public"."act_hi_identitylink" VALUES ('2506', null, 'participant', 'qwer', null, '2501');
INSERT INTO "public"."act_hi_identitylink" VALUES ('7502', null, 'starter', 'admin', null, '7501');
INSERT INTO "public"."act_hi_identitylink" VALUES ('7506', null, 'participant', 'qwer', null, '7501');

-- ----------------------------
-- Table structure for act_hi_procinst
-- ----------------------------
DROP TABLE IF EXISTS "public"."act_hi_procinst";
CREATE TABLE "public"."act_hi_procinst" (
"id_" varchar(64) COLLATE "default" NOT NULL,
"proc_inst_id_" varchar(64) COLLATE "default" NOT NULL,
"business_key_" varchar(255) COLLATE "default",
"proc_def_id_" varchar(64) COLLATE "default" NOT NULL,
"start_time_" timestamp(6) NOT NULL,
"end_time_" timestamp(6),
"duration_" int8,
"start_user_id_" varchar(255) COLLATE "default",
"start_act_id_" varchar(255) COLLATE "default",
"end_act_id_" varchar(255) COLLATE "default",
"super_process_instance_id_" varchar(64) COLLATE "default",
"delete_reason_" varchar(4000) COLLATE "default",
"tenant_id_" varchar(255) COLLATE "default" DEFAULT ''::character varying,
"name_" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of act_hi_procinst
-- ----------------------------
INSERT INTO "public"."act_hi_procinst" VALUES ('12501', '12501', 'fireworks:501', 'fireworks:1:3', '2015-11-28 21:42:48.152', null, null, 'admin', 'startevent1', null, null, null, '', null);
INSERT INTO "public"."act_hi_procinst" VALUES ('2501', '2501', 'fireworks:2', 'fireworks:1:3', '2015-09-10 17:39:48.195', null, null, 'admin', 'startevent1', null, null, null, '', null);
INSERT INTO "public"."act_hi_procinst" VALUES ('7501', '7501', 'fireworks:354', 'fireworks:1:3', '2015-11-09 20:54:28.103', null, null, 'admin', 'startevent1', null, null, null, '', null);

-- ----------------------------
-- Table structure for act_hi_taskinst
-- ----------------------------
DROP TABLE IF EXISTS "public"."act_hi_taskinst";
CREATE TABLE "public"."act_hi_taskinst" (
"id_" varchar(64) COLLATE "default" NOT NULL,
"proc_def_id_" varchar(64) COLLATE "default",
"task_def_key_" varchar(255) COLLATE "default",
"proc_inst_id_" varchar(64) COLLATE "default",
"execution_id_" varchar(64) COLLATE "default",
"name_" varchar(255) COLLATE "default",
"parent_task_id_" varchar(64) COLLATE "default",
"description_" varchar(4000) COLLATE "default",
"owner_" varchar(255) COLLATE "default",
"assignee_" varchar(255) COLLATE "default",
"start_time_" timestamp(6) NOT NULL,
"claim_time_" timestamp(6),
"end_time_" timestamp(6),
"duration_" int8,
"delete_reason_" varchar(4000) COLLATE "default",
"priority_" int4,
"due_date_" timestamp(6),
"form_key_" varchar(255) COLLATE "default",
"category_" varchar(255) COLLATE "default",
"tenant_id_" varchar(255) COLLATE "default" DEFAULT ''::character varying
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of act_hi_taskinst
-- ----------------------------
INSERT INTO "public"."act_hi_taskinst" VALUES ('10006', 'fireworks:1:3', 'usertask3', '7501', '7501', '现场复核审批', null, '烟花爆竹经营许可证流程', null, 'qwer', '2015-11-10 19:47:11.628', '2015-11-10 19:52:59.029', '2015-11-10 19:52:59.049', '347421', 'completed', '50', null, 'audit.form', null, '');
INSERT INTO "public"."act_hi_taskinst" VALUES ('10011', 'fireworks:1:3', 'usertask4', '7501', '7501', '审批委员会会签', null, '烟花爆竹经营许可证流程', null, 'qwer', '2015-11-10 19:52:59.049', '2015-11-10 19:53:25.94', '2015-11-10 19:53:25.96', '26911', 'completed', '50', null, 'audit.form', null, '');
INSERT INTO "public"."act_hi_taskinst" VALUES ('10016', 'fireworks:1:3', 'usertask5', '7501', '7501', '局长审批', null, '烟花爆竹经营许可证流程', null, 'qwer', '2015-11-10 19:53:25.96', null, null, null, null, '50', null, 'audit.form', null, '');
INSERT INTO "public"."act_hi_taskinst" VALUES ('12505', 'fireworks:1:3', 'usertask2', '12501', '12501', '符合性审批', null, '烟花爆竹经营许可证流程', null, 'qwer', '2015-11-28 21:42:48.161', null, null, null, null, '50', null, 'audit.form', null, '');
INSERT INTO "public"."act_hi_taskinst" VALUES ('2505', 'fireworks:1:3', 'usertask2', '2501', '2501', '符合性审批', null, '烟花爆竹经营许可证流程', null, 'qwer', '2015-09-10 17:39:48.207', '2015-09-10 21:47:42.343', '2015-09-10 21:47:42.526', '14874319', 'completed', '50', null, 'audit.form', null, '');
INSERT INTO "public"."act_hi_taskinst" VALUES ('5006', 'fireworks:1:3', 'usertask3', '2501', '2501', '现场复核审批', null, '烟花爆竹经营许可证流程', null, 'qwer', '2015-09-10 21:47:42.539', null, null, null, null, '50', null, 'audit.form', null, '');
INSERT INTO "public"."act_hi_taskinst" VALUES ('7505', 'fireworks:1:3', 'usertask2', '7501', '7501', '符合性审批', null, '烟花爆竹经营许可证流程', null, 'qwer', '2015-11-09 20:54:28.111', '2015-11-10 19:47:11.456', '2015-11-10 19:47:11.608', '82363497', 'completed', '50', null, 'audit.form', null, '');

-- ----------------------------
-- Table structure for act_hi_varinst
-- ----------------------------
DROP TABLE IF EXISTS "public"."act_hi_varinst";
CREATE TABLE "public"."act_hi_varinst" (
"id_" varchar(64) COLLATE "default" NOT NULL,
"proc_inst_id_" varchar(64) COLLATE "default",
"execution_id_" varchar(64) COLLATE "default",
"task_id_" varchar(64) COLLATE "default",
"name_" varchar(255) COLLATE "default" NOT NULL,
"var_type_" varchar(100) COLLATE "default",
"rev_" int4,
"bytearray_id_" varchar(64) COLLATE "default",
"double_" float8,
"long_" int8,
"text_" varchar(4000) COLLATE "default",
"text2_" varchar(4000) COLLATE "default",
"create_time_" timestamp(6),
"last_updated_time_" timestamp(6)
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of act_hi_varinst
-- ----------------------------
INSERT INTO "public"."act_hi_varinst" VALUES ('10002', '7501', '7501', null, 'accepted', 'boolean', '2', null, null, '1', null, null, '2015-11-10 19:47:11.588', '2015-11-10 19:53:25.952');
INSERT INTO "public"."act_hi_varinst" VALUES ('5002', '2501', '2501', null, 'accepted', 'boolean', '0', null, null, '1', null, null, '2015-09-10 21:47:42.515', '2015-09-10 21:47:42.515');

-- ----------------------------
-- Table structure for act_re_deployment
-- ----------------------------
DROP TABLE IF EXISTS "public"."act_re_deployment";
CREATE TABLE "public"."act_re_deployment" (
"id_" varchar(64) COLLATE "default" NOT NULL,
"name_" varchar(255) COLLATE "default",
"category_" varchar(255) COLLATE "default",
"tenant_id_" varchar(255) COLLATE "default" DEFAULT ''::character varying,
"deploy_time_" timestamp(6)
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of act_re_deployment
-- ----------------------------
INSERT INTO "public"."act_re_deployment" VALUES ('1', 'cn.com.rexen.demo.rest', null, '', '2015-09-10 17:21:46.165');

-- ----------------------------
-- Table structure for act_re_model
-- ----------------------------
DROP TABLE IF EXISTS "public"."act_re_model";
CREATE TABLE "public"."act_re_model" (
"id_" varchar(64) COLLATE "default" NOT NULL,
"rev_" int4,
"name_" varchar(255) COLLATE "default",
"key_" varchar(255) COLLATE "default",
"category_" varchar(255) COLLATE "default",
"create_time_" timestamp(6),
"last_update_time_" timestamp(6),
"version_" int4,
"meta_info_" varchar(4000) COLLATE "default",
"deployment_id_" varchar(64) COLLATE "default",
"editor_source_value_id_" varchar(64) COLLATE "default",
"editor_source_extra_value_id_" varchar(64) COLLATE "default",
"tenant_id_" varchar(255) COLLATE "default" DEFAULT ''::character varying
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of act_re_model
-- ----------------------------

-- ----------------------------
-- Table structure for act_re_procdef
-- ----------------------------
DROP TABLE IF EXISTS "public"."act_re_procdef";
CREATE TABLE "public"."act_re_procdef" (
"id_" varchar(64) COLLATE "default" NOT NULL,
"rev_" int4,
"category_" varchar(255) COLLATE "default",
"name_" varchar(255) COLLATE "default",
"key_" varchar(255) COLLATE "default" NOT NULL,
"version_" int4 NOT NULL,
"deployment_id_" varchar(64) COLLATE "default",
"resource_name_" varchar(4000) COLLATE "default",
"dgrm_resource_name_" varchar(4000) COLLATE "default",
"description_" varchar(4000) COLLATE "default",
"has_start_form_key_" bool,
"has_graphical_notation_" bool,
"suspension_state_" int4,
"tenant_id_" varchar(255) COLLATE "default" DEFAULT ''::character varying
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of act_re_procdef
-- ----------------------------
INSERT INTO "public"."act_re_procdef" VALUES ('fireworks:1:3', '3', 'http://www.activiti.org/test', '烟花爆竹经营许可证', 'fireworks', '1', '1', 'OSGI-INF/activiti/notice.bpmn20.xml', null, '烟花爆竹经营许可证流程', 't', 't', '1', '');

-- ----------------------------
-- Table structure for act_ru_event_subscr
-- ----------------------------
DROP TABLE IF EXISTS "public"."act_ru_event_subscr";
CREATE TABLE "public"."act_ru_event_subscr" (
"id_" varchar(64) COLLATE "default" NOT NULL,
"rev_" int4,
"event_type_" varchar(255) COLLATE "default" NOT NULL,
"event_name_" varchar(255) COLLATE "default",
"execution_id_" varchar(64) COLLATE "default",
"proc_inst_id_" varchar(64) COLLATE "default",
"activity_id_" varchar(64) COLLATE "default",
"configuration_" varchar(255) COLLATE "default",
"created_" timestamp(6) NOT NULL,
"proc_def_id_" varchar(64) COLLATE "default",
"tenant_id_" varchar(255) COLLATE "default" DEFAULT ''::character varying
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of act_ru_event_subscr
-- ----------------------------

-- ----------------------------
-- Table structure for act_ru_execution
-- ----------------------------
DROP TABLE IF EXISTS "public"."act_ru_execution";
CREATE TABLE "public"."act_ru_execution" (
"id_" varchar(64) COLLATE "default" NOT NULL,
"rev_" int4,
"proc_inst_id_" varchar(64) COLLATE "default",
"business_key_" varchar(255) COLLATE "default",
"parent_id_" varchar(64) COLLATE "default",
"proc_def_id_" varchar(64) COLLATE "default",
"super_exec_" varchar(64) COLLATE "default",
"act_id_" varchar(255) COLLATE "default",
"is_active_" bool,
"is_concurrent_" bool,
"is_scope_" bool,
"is_event_scope_" bool,
"suspension_state_" int4,
"cached_ent_state_" int4,
"tenant_id_" varchar(255) COLLATE "default" DEFAULT ''::character varying,
"name_" varchar(255) COLLATE "default",
"lock_time_" timestamp(6)
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of act_ru_execution
-- ----------------------------
INSERT INTO "public"."act_ru_execution" VALUES ('12501', '1', '12501', 'fireworks:501', null, 'fireworks:1:3', null, 'usertask2', 't', 'f', 't', 'f', '1', '2', '', null, null);
INSERT INTO "public"."act_ru_execution" VALUES ('2501', '2', '2501', 'fireworks:2', null, 'fireworks:1:3', null, 'usertask3', 't', 'f', 't', 'f', '1', '2', '', null, null);
INSERT INTO "public"."act_ru_execution" VALUES ('7501', '4', '7501', 'fireworks:354', null, 'fireworks:1:3', null, 'usertask5', 't', 'f', 't', 'f', '1', '2', '', null, null);

-- ----------------------------
-- Table structure for act_ru_identitylink
-- ----------------------------
DROP TABLE IF EXISTS "public"."act_ru_identitylink";
CREATE TABLE "public"."act_ru_identitylink" (
"id_" varchar(64) COLLATE "default" NOT NULL,
"rev_" int4,
"group_id_" varchar(255) COLLATE "default",
"type_" varchar(255) COLLATE "default",
"user_id_" varchar(255) COLLATE "default",
"task_id_" varchar(64) COLLATE "default",
"proc_inst_id_" varchar(64) COLLATE "default",
"proc_def_id_" varchar(64) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of act_ru_identitylink
-- ----------------------------
INSERT INTO "public"."act_ru_identitylink" VALUES ('12502', '1', null, 'starter', 'admin', null, '12501', null);
INSERT INTO "public"."act_ru_identitylink" VALUES ('12506', '1', null, 'participant', 'qwer', null, '12501', null);
INSERT INTO "public"."act_ru_identitylink" VALUES ('2502', '1', null, 'starter', 'admin', null, '2501', null);
INSERT INTO "public"."act_ru_identitylink" VALUES ('2506', '1', null, 'participant', 'qwer', null, '2501', null);
INSERT INTO "public"."act_ru_identitylink" VALUES ('7502', '1', null, 'starter', 'admin', null, '7501', null);
INSERT INTO "public"."act_ru_identitylink" VALUES ('7506', '1', null, 'participant', 'qwer', null, '7501', null);

-- ----------------------------
-- Table structure for act_ru_job
-- ----------------------------
DROP TABLE IF EXISTS "public"."act_ru_job";
CREATE TABLE "public"."act_ru_job" (
"id_" varchar(64) COLLATE "default" NOT NULL,
"rev_" int4,
"type_" varchar(255) COLLATE "default" NOT NULL,
"lock_exp_time_" timestamp(6),
"lock_owner_" varchar(255) COLLATE "default",
"exclusive_" bool,
"execution_id_" varchar(64) COLLATE "default",
"process_instance_id_" varchar(64) COLLATE "default",
"proc_def_id_" varchar(64) COLLATE "default",
"retries_" int4,
"exception_stack_id_" varchar(64) COLLATE "default",
"exception_msg_" varchar(4000) COLLATE "default",
"duedate_" timestamp(6),
"repeat_" varchar(255) COLLATE "default",
"handler_type_" varchar(255) COLLATE "default",
"handler_cfg_" varchar(4000) COLLATE "default",
"tenant_id_" varchar(255) COLLATE "default" DEFAULT ''::character varying
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of act_ru_job
-- ----------------------------

-- ----------------------------
-- Table structure for act_ru_task
-- ----------------------------
DROP TABLE IF EXISTS "public"."act_ru_task";
CREATE TABLE "public"."act_ru_task" (
"id_" varchar(64) COLLATE "default" NOT NULL,
"rev_" int4,
"execution_id_" varchar(64) COLLATE "default",
"proc_inst_id_" varchar(64) COLLATE "default",
"proc_def_id_" varchar(64) COLLATE "default",
"name_" varchar(255) COLLATE "default",
"parent_task_id_" varchar(64) COLLATE "default",
"description_" varchar(4000) COLLATE "default",
"task_def_key_" varchar(255) COLLATE "default",
"owner_" varchar(255) COLLATE "default",
"assignee_" varchar(255) COLLATE "default",
"delegation_" varchar(64) COLLATE "default",
"priority_" int4,
"create_time_" timestamp(6),
"due_date_" timestamp(6),
"category_" varchar(255) COLLATE "default",
"suspension_state_" int4,
"tenant_id_" varchar(255) COLLATE "default" DEFAULT ''::character varying,
"form_key_" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of act_ru_task
-- ----------------------------
INSERT INTO "public"."act_ru_task" VALUES ('10016', '1', '7501', '7501', 'fireworks:1:3', '局长审批', null, '烟花爆竹经营许可证流程', 'usertask5', null, 'qwer', null, '50', '2015-11-10 19:53:25.96', null, null, '1', '', 'audit.form');
INSERT INTO "public"."act_ru_task" VALUES ('12505', '1', '12501', '12501', 'fireworks:1:3', '符合性审批', null, '烟花爆竹经营许可证流程', 'usertask2', null, 'qwer', null, '50', '2015-11-28 21:42:48.161', null, null, '1', '', 'audit.form');
INSERT INTO "public"."act_ru_task" VALUES ('5006', '1', '2501', '2501', 'fireworks:1:3', '现场复核审批', null, '烟花爆竹经营许可证流程', 'usertask3', null, 'qwer', null, '50', '2015-09-10 21:47:42.539', null, null, '1', '', 'audit.form');

-- ----------------------------
-- Table structure for act_ru_variable
-- ----------------------------
DROP TABLE IF EXISTS "public"."act_ru_variable";
CREATE TABLE "public"."act_ru_variable" (
"id_" varchar(64) COLLATE "default" NOT NULL,
"rev_" int4,
"type_" varchar(255) COLLATE "default" NOT NULL,
"name_" varchar(255) COLLATE "default" NOT NULL,
"execution_id_" varchar(64) COLLATE "default",
"proc_inst_id_" varchar(64) COLLATE "default",
"task_id_" varchar(64) COLLATE "default",
"bytearray_id_" varchar(64) COLLATE "default",
"double_" float8,
"long_" int8,
"text_" varchar(4000) COLLATE "default",
"text2_" varchar(4000) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of act_ru_variable
-- ----------------------------
INSERT INTO "public"."act_ru_variable" VALUES ('10002', '1', 'boolean', 'accepted', '7501', '7501', null, null, null, '1', null, null);
INSERT INTO "public"."act_ru_variable" VALUES ('5002', '1', 'boolean', 'accepted', '2501', '2501', null, null, null, '1', null, null);

-- ----------------------------
-- Table structure for cm_contract
-- ----------------------------
DROP TABLE IF EXISTS "public"."cm_contract";
CREATE TABLE "public"."cm_contract" (
"id" int8 NOT NULL,
"createby" varchar(255) COLLATE "default",
"creationdate" timestamp(6),
"updateby" varchar(255) COLLATE "default",
"updatedate" timestamp(6),
"version_" int8,
"archive" bool,
"archive_date" date,
"constractdate" date,
"constractnumber" varchar(100) COLLATE "default",
"contractstatus" int4,
"createdate" timestamp(6),
"expectedcost" float4,
"expiredate" date,
"grossprofit" float4,
"grossprofitrate" float4,
"guarantee" varchar(80) COLLATE "default",
"managerid" int8 NOT NULL,
"partya" varchar(255) COLLATE "default",
"partyb" varchar(100) COLLATE "default",
"projectname" varchar(100) COLLATE "default",
"projectstatus" varchar(10) COLLATE "default",
"projecttype" varchar(20) COLLATE "default",
"receivables" float4,
"receivemoney" float4,
"remark" varchar(255) COLLATE "default",
"sellerid" int8 NOT NULL,
"summoney" float4,
"userid" int8 NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of cm_contract
-- ----------------------------

-- ----------------------------
-- Table structure for couchdb_attach
-- ----------------------------
DROP TABLE IF EXISTS "public"."couchdb_attach";
CREATE TABLE "public"."couchdb_attach" (
"id" int8 NOT NULL,
"createby" varchar(255) COLLATE "default",
"creationdate" timestamp(6),
"updateby" varchar(255) COLLATE "default",
"updatedate" timestamp(6),
"version_" int8,
"attachname" varchar(255) COLLATE "default",
"attachpath" varchar(255) COLLATE "default",
"attachsize" int8 NOT NULL,
"attachtype" varchar(255) COLLATE "default",
"couchdbattachid" varchar(255) COLLATE "default",
"couchdbattachrev" varchar(255) COLLATE "default",
"mainid" int8 NOT NULL,
"othername" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of couchdb_attach
-- ----------------------------
INSERT INTO "public"."couchdb_attach" VALUES ('94', null, '2015-10-09 11:59:25.595', null, '2015-10-09 12:04:19.171', '1', 'modules.hello.iml', 'a67edc45b69943c8a67c479177f53149/modules.hello.iml', '3973', 'application/octet-stream', 'a67edc45b69943c8a67c479177f53149', '1-455780c90e0e91cb9625f2dde56ef8da', '123', '2888726918290.iml');
INSERT INTO "public"."couchdb_attach" VALUES ('95', null, '2015-10-09 15:10:31.398', null, '2015-10-09 15:10:31.398', '0', 'modules.hello.iml', '2946e9ac30464dcbb0a5c697aad42e77/modules.hello.iml', '3973', 'application/octet-stream', '2946e9ac30464dcbb0a5c697aad42e77', '1-455780c90e0e91cb9625f2dde56ef8da', '321', '2888749262796.iml');
INSERT INTO "public"."couchdb_attach" VALUES ('96', null, '2015-10-09 15:11:54.397', null, '2015-10-09 15:11:54.397', '0', 'modules.hello.iml', 'c19561f12f604427889571ba26765657/modules.hello.iml', '3973', 'application/octet-stream', 'c19561f12f604427889571ba26765657', '1-455780c90e0e91cb9625f2dde56ef8da', '321', '2888749428794.iml');
INSERT INTO "public"."couchdb_attach" VALUES ('97', null, '2015-10-09 15:17:03.011', null, '2015-10-09 15:17:03.011', '0', 'modules.hello.iml', 'f5c3e0987404472bb2f245b5830c3ddc/modules.hello.iml', '3973', 'application/octet-stream', 'f5c3e0987404472bb2f245b5830c3ddc', '1-455780c90e0e91cb9625f2dde56ef8da', '321', '2888750046022.iml');
INSERT INTO "public"."couchdb_attach" VALUES ('98', null, '2015-10-09 15:29:54.253', null, '2015-10-09 15:29:54.253', '0', 'pom.xml', '52935c2a907b4531a8d3411d36188083/pom.xml', '3559', 'application/octet-stream', '52935c2a907b4531a8d3411d36188083', '1-f3109b5fa3f0f74d02dd33818ac66cf0', '321', '2888751588506.xml');

-- ----------------------------
-- Table structure for middleware_attachment
-- ----------------------------
DROP TABLE IF EXISTS "public"."middleware_attachment";
CREATE TABLE "public"."middleware_attachment" (
"id" int8 NOT NULL,
"createby" varchar(255) COLLATE "default",
"creationdate" timestamp(6),
"updateby" varchar(255) COLLATE "default",
"updatedate" timestamp(6),
"attachmentid" varchar(255) COLLATE "default",
"attachmentname" varchar(255) COLLATE "default",
"attachmentpath" varchar(255) COLLATE "default",
"attachmentrev" varchar(255) COLLATE "default",
"attachmentsize" int8,
"attachmenttype" varchar(255) COLLATE "default",
"mainid" int8,
"uploaddate" timestamp(6),
"version_" int8
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of middleware_attachment
-- ----------------------------
INSERT INTO "public"."middleware_attachment" VALUES ('24011', '管理员', '2015-11-30 10:39:16.579', '管理员', '2015-11-30 10:39:16.579', 'd6e36d6f65254b0697b3dc607914e530', '工作簿3.xlsx', 'http://localhost:5984/kalix/d6e36d6f65254b0697b3dc607914e530/工作簿3.xlsx', '1-5ffc832275f1b520f8151b4c5d599fb8', '48003', 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet', '25', '2015-11-30 10:39:16.579', '1');
INSERT INTO "public"."middleware_attachment" VALUES ('24012', '管理员', '2015-11-30 10:43:39.954', '管理员', '2015-11-30 10:43:39.954', 'd69201a83f5a40c780b5a658c848f9a2', '协同办公及项目管理系统设计说明书.doc', 'http://localhost:5984/kalix/d69201a83f5a40c780b5a658c848f9a2/协同办公及项目管理系统设计说明书.doc', '1-f1344850337acd7cf5cfb927a52f7213', '371712', 'application/msword', '40', '2015-11-30 10:43:39.954', '1');
INSERT INTO "public"."middleware_attachment" VALUES ('24013', '管理员', '2015-11-30 10:48:27.625', '管理员', '2015-11-30 10:48:27.625', '404ddb5fb2cb4b7b85605f249e98ff15', 'oa.EAP', 'http://localhost:5984/kalix/404ddb5fb2cb4b7b85605f249e98ff15/oa.EAP', '1-71720b886ae2e7dc299636e3ffeb517e', '1296384', 'application/octet-stream', '31', '2015-11-30 10:48:27.625', '1');
INSERT INTO "public"."middleware_attachment" VALUES ('24014', '管理员', '2015-11-30 10:48:33.823', '管理员', '2015-11-30 10:48:33.823', '54eff5d322d1470c943abeb6c6b89350', '2015年营销任务完成情况表20151113.xlsx', 'http://localhost:5984/kalix/54eff5d322d1470c943abeb6c6b89350/2015年营销任务完成情况表20151113.xlsx', '1-4c21641e3f536529e66d7b5777dc1624', '81035', 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet', '31', '2015-11-30 10:48:33.823', '1');

-- ----------------------------
-- Table structure for openjpaseq
-- ----------------------------
DROP TABLE IF EXISTS "public"."openjpaseq";
CREATE TABLE "public"."openjpaseq" (
"id" int2 NOT NULL,
"sequence_value" int8
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of openjpaseq
-- ----------------------------
INSERT INTO "public"."openjpaseq" VALUES ('0', '26810');

-- ----------------------------
-- Table structure for roffice_chance
-- ----------------------------
DROP TABLE IF EXISTS "public"."roffice_chance";
CREATE TABLE "public"."roffice_chance" (
"id" int8 NOT NULL,
"createby" varchar(255) COLLATE "default",
"creationdate" timestamp(6),
"updateby" varchar(255) COLLATE "default",
"updatedate" timestamp(6),
"version_" int8,
"billdate" date,
"budget" varchar(255) COLLATE "default",
"clientname" varchar(255) COLLATE "default",
"clientphone" varchar(255) COLLATE "default",
"comment" varchar(255) COLLATE "default",
"description" varchar(255) COLLATE "default",
"industry" varchar(255) COLLATE "default",
"level" varchar(255) COLLATE "default",
"name" varchar(255) COLLATE "default",
"salerid" varchar(255) COLLATE "default",
"supporterid" varchar(255) COLLATE "default",
"type" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of roffice_chance
-- ----------------------------

-- ----------------------------
-- Table structure for roffice_contract
-- ----------------------------
DROP TABLE IF EXISTS "public"."roffice_contract";
CREATE TABLE "public"."roffice_contract" (
"id" int8 NOT NULL,
"createby" varchar(255) COLLATE "default",
"creationdate" timestamp(6),
"updateby" varchar(255) COLLATE "default",
"updatedate" timestamp(6),
"version_" int8,
"archive" bool,
"archive_date" timestamp(6),
"contractdate" timestamp(6),
"contractnumber" varchar(255) COLLATE "default",
"contractstatus" int4,
"expectedcost" float4,
"expiredate" timestamp(6),
"grossprofit" float4,
"grossprofitrate" float4,
"guarantee" varchar(255) COLLATE "default",
"partya" varchar(255) COLLATE "default",
"partyb" varchar(255) COLLATE "default",
"projectid" varchar(255) COLLATE "default",
"projectname" varchar(255) COLLATE "default",
"receivables" float4,
"receivemoney" float4,
"remark" varchar(255) COLLATE "default",
"summoney" float4,
"manager" varchar(255) COLLATE "default",
"projecttype" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of roffice_contract
-- ----------------------------
INSERT INTO "public"."roffice_contract" VALUES ('1', null, null, null, null, null, null, null, '0001-01-01 00:00:00', 'ZT-XS-2015001', null, '1.872e+006', null, '100000', '0.0507099', '一年', '北京荣之联科技股份有限公司', '中天', null, '北京荣之联科技股份有限公司SAP销售项目', '1.972e+006', '1.872e+006', '（1）买方收到卖方开具的合同金额的全款增值税专用发票后，以银行承兑汇票方式支付卖方1872000.00元，大写：壹佰捌拾柒万贰仟元整，银行承兑日期为收到发票之日起180天。
（2）买方收到最终用户全款后，以电汇形式支付余款100000.00元，大写：十万元整
', '1.972e+006', '彭程', '软件开发');
INSERT INTO "public"."roffice_contract" VALUES ('2', null, null, null, null, null, null, null, '0001-01-01 00:00:00', 'ZT-JC-2015001', null, '1.26988e+006', null, '128038', '0.091592', '一年', '吉林省农业农科院', '中天', null, '吉林农业科技学院网络改造工程', '1.39792e+006', '1.39792e+006', '项目验收三日内，支付全部合同金额1,397,917元', '1.39792e+006', '彭程', '系统集成');
INSERT INTO "public"."roffice_contract" VALUES ('3', null, null, null, null, null, null, null, '0001-01-01 00:00:00', 'ZT-XS-2015002', null, '18958', null, '14644', '0.435807', '一年', '长春市检察院', '中天', null, '长春市检察院新增设备项目', '33602', '33602', '合同签定后，需方收到货3日内向供方支付合同全部价款（即人民币：17064元，大写：壹万柒仟零陆拾肆元整）', '33602', '李鑫', '系统集成');
INSERT INTO "public"."roffice_contract" VALUES ('4', null, null, null, null, null, null, null, '0001-01-01 00:00:00', 'ZT-XS-2015004', null, '3395', null, '105', '0.03', '', '镇赉县社会保险事业管理局', '中天', null, '镇赉县社会保险事业管理局网卡采购', '3500', '3500', '一次性付清', '3500', '彭程', '系统集成');
INSERT INTO "public"."roffice_contract" VALUES ('5', null, null, null, null, null, null, null, null, 'ZT-XS-2015005', null, '42131', null, '0', '0', '', '', '中天', null, '远洋戛纳', '0', '0', '', '0', '彭程', '系统集成');
INSERT INTO "public"."roffice_contract" VALUES ('6', null, null, null, null, null, null, null, '0001-01-01 00:00:00', 'ZT-XS-2015006', null, '28393.6', null, '26122.4', '0.479169', '一年', '长春市纪检委', '中天', null, '长春市纪检委净月西山宾馆监控系统', '54516', '54516', '需方收到货三日内支付全部合同款 49636元。', '54516', '李鑫', '系统集成');
INSERT INTO "public"."roffice_contract" VALUES ('7', null, null, null, null, null, null, null, null, 'ZT-JF-2015001', null, '0', null, '200000', '1', '', '', '中天', null, '技术服务合同', '200000', '200000', '一次性付清', '200000', '余娜', '技术服务');
INSERT INTO "public"."roffice_contract" VALUES ('8', null, null, null, null, null, null, null, '0001-01-01 00:00:00', 'ZT-JF-2015002', null, '1480', null, '13520', '0.901333', '一年', '长春市纪检委', '中天', null, '长春市纪检委净月办案场所弱电系统工程项目维护', '15000', '15000', '签订合同后一次性付清全部合同额，即小写：15000元', '15000', '李鑫', '技术服务');
INSERT INTO "public"."roffice_contract" VALUES ('9', null, null, null, null, null, null, null, '0001-01-01 00:00:00', 'LC-JK-2015001', null, '0', null, '89000', '1', '一年', '吉林省高速公路实业总公司通信工程分公司', '蓝策', null, '吉林省高速公路管理局ETC客服网站', '89000', '0', '项目验收合格后，三日内甲方支付乙方全部合同款', '89000', '曹璐', '软件开发');
INSERT INTO "public"."roffice_contract" VALUES ('10', null, null, null, null, null, null, null, '0001-01-01 00:00:00', 'ZT-XS-2015007', null, '1240', null, '11609', '0.903494', '一年', '长春市人民检察院政治部警务处', '中天', null, '长春市检察院半球摄像机及门禁电插锁采购', '12849', '12849', '甲方在收到发票后7日内支付给乙方合同总价的100％', '12849', '李鑫', '系统集成');
INSERT INTO "public"."roffice_contract" VALUES ('11', null, null, null, null, null, null, null, '0001-01-01 00:00:00', 'ZT-XS-2015008', null, '4.73625e+006', null, '743750', '0.149347', '三年', '中海网络', '中天', null, '中海网络科技股份有限公司浪潮设备采购项目(省高管局国标ETC改造项目)', '4.98e+006', '4.98e+006', '1) 甲方在合同签订后14日内向乙方支付合同总金额的30％ 作为预付款。
2) 乙方将本合同项下全部设备运抵甲方指定地点并完成验收后，甲方支付到合同总金额的80％。
3) 交工验收合格后14个工作日内，甲方支付到合同总金额的100％。
', '4.98e+006', '曹璐', '系统集成');
INSERT INTO "public"."roffice_contract" VALUES ('12', null, null, null, null, null, null, null, '0001-01-01 00:00:00', 'RX-JF-2015001', null, '0', null, '96000', '1', '', '吉林省建设厅', '锐迅', null, '吉林省建设厅公建平台维护', '96000', '0', '', '96000', '李鑫', '技术服务');
INSERT INTO "public"."roffice_contract" VALUES ('13', null, null, null, null, null, null, null, '0001-01-01 00:00:00', 'ZT-JF-2015003', null, '90000', null, '30000', '0.25', '一年', '中共吉林省委保健委员会办公室  ', '中天', null, '省委保健办中心机房信息系统技术维护项目', '120000', '120000', '技术服务费由甲方一次性支付乙方', '120000', '彭程', '技术服务');
INSERT INTO "public"."roffice_contract" VALUES ('14', null, null, null, null, null, null, null, '0001-01-01 00:00:00', 'RX-XS-2015001', null, '3.67895e+006', null, '158000', '0.04', '五年', '吉大正元', '锐迅', null, '长春吉大正元华为设备销售项目', '3.95e+006', '3.95e+006', '合同签署后甲方以电汇方式支付乙方20%货款，甲方收到货物及全额发票2个月内，甲方以电汇方式支付乙方80%货款。', '3.95e+006', '彭程', '系统集成');
INSERT INTO "public"."roffice_contract" VALUES ('15', null, null, null, null, null, null, null, '0001-01-01 00:00:00', 'RX-XS-2015001(1)', null, '322620', null, '12000', '0.04', '', '吉大正元', '锐迅', null, '长春吉大正元华为设备安装调试项目', '300000', '300000', '合同签署后甲方以电汇方式支付乙方20%货款，甲方收到货物及全额发票2个月内，甲方以电汇方式支付乙方80%货款。', '300000', '彭程', '技术服务');
INSERT INTO "public"."roffice_contract" VALUES ('16', null, null, null, null, null, null, null, '0001-01-01 00:00:00', 'ZT-GC-2015001', null, '306004', null, '176280', '0.365511', '工程竣工后1年', '四平市人防办', '中天', null, '四平市人防战备值班室改造项目', '482284', '482284', '合同签订后3个工作日内甲方支付给乙方合同额的70%，产品安装调试完毕并经甲方验收合格后5-10个工作日内支付尾款给乙方。', '482284', '李鑫', '系统集成');
INSERT INTO "public"."roffice_contract" VALUES ('17', null, null, null, null, null, null, null, '0001-01-01 00:00:00', 'ZT-GC-2015002', null, '26892', null, '21694', '0.446507', '合同竣工后1年', '长春市净月西山宾馆有限责任公司', '中天', null, '长春市净月西山宾馆门禁监控系统', '48586', '0', '合同签定后，30日内将货物保质保量发出，需方收到货3日内向供方支付合同全部价款。', '48586', '李鑫', '系统集成');
INSERT INTO "public"."roffice_contract" VALUES ('18', null, null, null, null, null, null, null, '0001-01-01 00:00:00', 'ZT-XS-2015010', null, '27469', null, '29531', '0.518088', '一年', '辽源市人防办', '中天', null, '辽源市人民防空办公室一机三屏项目', '57000', '57000', '验收合格后一次性付全款', '57000', '李鑫', '系统集成');
INSERT INTO "public"."roffice_contract" VALUES ('19', null, null, null, null, null, null, null, '0001-01-01 00:00:00', 'ZT-JF-2015004', null, '46000', null, '3800', '0.0763052', '一年', '吉林省地震局', '中天', null, '吉林省地震局LAN技术服务项目', '49800', '49800', '甲方与乙方签订合同后7工作日内，将合同总额以人民币形式汇至乙方指定的银行账户。', '49800', '彭程', '技术服务');
INSERT INTO "public"."roffice_contract" VALUES ('20', null, null, null, null, null, null, null, '0001-01-01 00:00:00', 'RX-XS-2015003', null, '826091', null, '38915', '0.0400002', '三年', '吉大正元', '锐迅', null, '长春吉大正元公安厅项目华为设备销售项目', '972870', '740713', '合同签署后甲方以电汇方式支付乙方10%货款，甲方收到货物及全额发票2个月内，甲方以电汇方式支付乙方90%货款。', '972870', '彭程', '系统集成');
INSERT INTO "public"."roffice_contract" VALUES ('21', null, null, null, null, null, null, null, '0001-01-01 00:00:00', 'ZT-JC-2015004', null, '383480', null, '35000', '0.0886076', '', '吉林省档案局', '中天', null, '吉林省档案局磁盘阵列项目', '395000', '395000', '财政厅收到合同约定付款文件后15个工作日内，采用银行转账方式将合同价款中财政付款金额一次性支付给供方。', '395000', '彭程', '系统集成');
INSERT INTO "public"."roffice_contract" VALUES ('22', null, null, null, null, null, null, null, '0001-01-01 00:00:00', 'ZT-JF-2015005', null, '0', null, '84000', '1', '一年', '吉林省人防办', '中天', null, '吉林省人防办OA系统拓展性可研论证', '84000', '0', '合同签订后3日内，一次性付清全部合同款。', '84000', '余娜', '技术服务');
INSERT INTO "public"."roffice_contract" VALUES ('23', null, null, null, null, null, null, null, null, 'ZT-GC-2015003', null, '8939.52', null, '276.48', '0.03', '', '中国建设银行股份有限公司', '中天', null, '长春市北亚泰大街离行式自助银行综合布线工程', '9216', '9216', '', '9216', '彭程', '系统集成');
INSERT INTO "public"."roffice_contract" VALUES ('24', null, null, null, null, null, null, null, null, 'ZT-GC-2015004', null, '22348.8', null, '691.2', '0.03', '', '中国建设银行股份有限公司', '中天', null, '长春市新光复路离行式自助银行综合布线工程', '23040', '23040', '', '23040', '彭程', '系统集成');
INSERT INTO "public"."roffice_contract" VALUES ('25', null, null, null, null, null, null, null, null, 'RX-JK-2015002', null, '577700', null, '917300', '0.613579', '', '吉林（中国=新加坡）食品区食品药品监督管理局', '锐迅', null, '吉林（中国=新加坡）食品区食品药品监督管理局保障体系综合监管平台一期建设项目', '1.495e+006', '1.0465e+006', '合同签订后3个工作日内甲方支付给乙方合同额的70%，1046500元，产品安装调试完毕并经甲方验收合格后5-10个工作日内支付尾款给乙方。448500元', '1.495e+006', '余娜', '软件开发');
INSERT INTO "public"."roffice_contract" VALUES ('26', null, null, null, null, null, null, null, '0001-01-01 00:00:00', 'ZT-JC-2015005', null, '7.22466e+006', null, '223443', '0.03', '一年', '长春汽车经济技术开发区教育局', '中天', null, '长春汽车经济技术开发区教育局信息化教学设备项目', '7.4481e+006', '3.72405e+006', '本合同的付款方式为：合同签订后，合同货物全部到达指定地点后支付合同金额50%，即：叁佰柒拾贰万肆仟零伍拾元整（小写：3724050.00），安装调试验收合格后15个工作日支付合同全部余款的45%，即：叁佰叁拾伍万壹仟陆佰肆拾伍元整（小写：3351645.00），剩余的5%合同金额即叁拾柒万贰仟肆佰零伍元（小写：372，405.00）作为产品质保金，保证期为1年。', '7.4481e+006', '彭程', '系统集成');
INSERT INTO "public"."roffice_contract" VALUES ('27', null, null, null, null, null, null, null, null, 'ZT-XS-2015013', null, '1620', null, '1380', '0.46', '', '吉林省工商行政管理局', '中天', null, '吉林省工商行政管理局设备采购', '3000', '0', '到货后一次性付款', '3000', '彭程', '系统集成');
INSERT INTO "public"."roffice_contract" VALUES ('28', null, null, null, null, null, null, null, '0001-01-01 00:00:00', 'ZT-XS-2015011', null, '2900', null, '935', '0.243807', '', '吉林省湾沟林业局', '中天', null, '吉林省湾沟林业局交换机采购', '3835', '0', '到货后一次性付款', '3835', '余娜', '系统集成');
INSERT INTO "public"."roffice_contract" VALUES ('29', null, null, null, null, null, null, null, '0001-01-01 00:00:00', 'ZT-XS-2015014', null, '0', null, '5000', '1', '', '长春市人民检察院', '中天', null, '长春市人民检察院大屏维修', '5000', '0', '一次性付款', '5000', '李鑫', '系统集成');
INSERT INTO "public"."roffice_contract" VALUES ('30', null, null, null, null, null, null, null, '0001-01-01 00:00:00', 'RX-JK-2015003', null, '185000', null, '18500', '0.0909091', '', '中移全通系统集成有限公司', '锐迅', null, '农村电影监控系统', '203500', '0', '初验收支付合同额的70%,即142450元，终验后支付20%即40700元，验收后运行稳定一个月后支付剩余10%，即20350元。', '203500', '李鑫', '软件开发');
INSERT INTO "public"."roffice_contract" VALUES ('31', null, null, null, null, null, null, null, '0001-01-01 00:00:00', 'RX-JF-2015003', null, '0', null, '580000', '1', '', '吉林省食品药品监督管理局', '锐迅', null, '吉林省食品药品监督管理局综合信息平台运维', '580000', '0', '验收后一次性支付', '580000', '彭程', '软件开发');
INSERT INTO "public"."roffice_contract" VALUES ('33', null, null, null, null, null, null, null, '0001-01-01 00:00:00', 'ZT-XS-2015015', null, '29500', null, '2800', '0.0866873', '', '吉林省平宇电子', '中天', null, '吉林省平宇电子浪潮设备采购', '32300', '32300', '一次性付款', '32300', '李鑫', '系统集成');
INSERT INTO "public"."roffice_contract" VALUES ('34', null, null, null, null, null, null, null, '0001-01-01 00:00:00', 'RX-JF-2015002', null, '0', null, '50000', '1', '', '白城市发展和改革委员会', '锐迅', null, '白城市农畜产品评价与推介信息平台建设方案', '50000', '50000', '一次性付款', '50000', '余娜', '技术服务');
INSERT INTO "public"."roffice_contract" VALUES ('35', null, null, null, null, null, null, null, '0001-01-01 00:00:00', 'ZT-JF-2015007', null, '200000', null, '139200', '0.410377', '', '中国移动吉林公司', '中天', null, '中国移动吉林公司2015年网管支撑系统数据库优化服务框架采购合同', '339200', '0', '上线款：本合同约定的标的服务完全实现，且上线后3日内由乙方开具付款通知单，甲方收到付款通知单后10日向乙方支付；
初验款：乙方完成数据优化服务工作后，经甲方初验后，支付合同总价的30%；
终验款：乙方完成全部数据优化服务工作，并提交服务资料档案相关数据，经甲方验收通过后10个工作日内，甲方向乙方支付补充合同总价的20%。', '339200', '祖克永', '技术服务');
INSERT INTO "public"."roffice_contract" VALUES ('36', null, null, null, null, null, null, null, '0001-01-01 00:00:00', 'ZT-XS-2015016', null, '14700', null, '5150', '0.259446', '', '北京鑫裕富华科技有限公司', '中天', null, '北京鑫裕富华科技有限公司防火墙采购', '19850', '19850', '签订合同开具发票后，一次性支付全部合同款。', '19850', '彭程', '系统集成');
INSERT INTO "public"."roffice_contract" VALUES ('37', null, null, null, null, null, null, null, '0001-01-01 00:00:00', 'ZT-JC-2015009', null, '2.29052e+006', null, '4.22948e+006', '0.648693', '', '吉林省工商行政管理局', '中天', null, '吉林省工商行政管理局一照一码业务平台硬件建设项目', '6.52e+006', '0', '设备到货验收合格后15个工作日内支付50%，即326000元，安装调试验收合格后15个工作日内支付剩余50%，即3260000元', '6.52e+006', '曹璐', '系统集成');
INSERT INTO "public"."roffice_contract" VALUES ('38', null, null, null, null, null, null, null, null, '', null, '116710', null, '33290', '0.221933', '', '吉林省食品药品监督管理局', '中天', null, '吉林省食品药品监督管理局信息化建设设备采购项目', '150000', '0', '', '150000', '彭程', '系统集成');
INSERT INTO "public"."roffice_contract" VALUES ('39', null, null, null, null, null, null, null, null, '', null, '235351', null, '43049', '0.15463', '', '北京东华合创科技有限公司 ', '中天', null, '吉林省食品药品监督管理局信息化建设设备采购项目', '278400', '0', '', '278400', '彭程', '系统集成');
INSERT INTO "public"."roffice_contract" VALUES ('40', null, null, null, null, null, null, null, null, '', null, '0', null, '288000', '1', '', '北京东华合创科技有限公司 ', '中天', null, '吉林省食品药品监督管理局信息化建设设备采购项目', '288000', '0', '', '288000', '彭程', '软件开发');
INSERT INTO "public"."roffice_contract" VALUES ('41', null, null, null, null, null, null, null, '0001-01-01 00:00:00', 'ZT-GC-2015005', null, '600000', null, '393565', '0.396114', '', '白城市人民防空办公室', '中天', null, '白城市人防办地下指挥中心改造项目', '993565', '695495', '签订合同3日内支付70%，即695495.36元，验收后5-10个工作日支付剩余30%，即298069.43元', '993565', '余娜', '系统集成');
INSERT INTO "public"."roffice_contract" VALUES ('42', null, null, null, null, null, null, null, null, 'ZT-JK-2015001', null, '190000', null, '560000', '0.746667', '', '吉林省人民防空办公室', '中天', null, '吉林省人防一体化数据工程', '750000', '750000', '', '750000', '余娜', '软件开发');
INSERT INTO "public"."roffice_contract" VALUES ('43', null, null, null, null, null, null, null, '0001-01-01 00:00:00', 'ZT-JC-2015010', null, '1.51769e+006', null, '352312', '0.188402', '', '吉林省住房和城乡建设厅', '中天', null, '吉林省住房和城乡建设厅（本级）吉林省房产信息查核报送综合信息平台硬件设备', '1.87e+006', '0', '合同验收合格后5个工作日内，向省财政厅提交约定的付款文件，采购办收到付款文件后15个工作日内，一次性支付。', '1.87e+006', '李鑫', '系统集成');
INSERT INTO "public"."roffice_contract" VALUES ('44', null, null, null, null, null, null, null, '0001-01-01 00:00:00', 'ZT-XS-2015012', null, '24800', null, '74600', '0.750503', '', '吉林省人防', '中天', null, '吉林省人防设备销售合同', '99400', '99400', '', '99400', '余娜', '系统集成');
INSERT INTO "public"."roffice_contract" VALUES ('45', null, null, null, null, null, null, null, null, '', null, '155100', null, '9900', '0.06', '', '六十八中学', '中天', null, '六十八中学教学仪器设备采购 ', '165000', '0', '', '165000', '彭程', '系统集成');
INSERT INTO "public"."roffice_contract" VALUES ('46', null, null, null, null, null, null, null, null, '', null, '535800', null, '34200', '0.06', '', '朝阳实验小学', '中天', null, '长春市朝阳实验小学设备采购 ', '570000', '0', '', '570000', '彭程', '系统集成');
INSERT INTO "public"."roffice_contract" VALUES ('47', null, null, null, null, null, null, null, null, '', null, '39386', null, '2514', '0.06', '', '朝阳区安民街小学校', '中天', null, '长春市朝阳区安民街小学校', '41900', '0', '', '41900', '彭程', '系统集成');
INSERT INTO "public"."roffice_contract" VALUES ('48', null, null, null, null, null, null, null, '0001-01-01 00:00:00', 'ZT-XS-2015017', null, '201590', null, '19540', '0.0883643', '', '网神信息技术北京股份有限公司', '中天', null, '网神公司浪潮设备采购合同', '221130', '0', '', '221130', '彭程', '系统集成');
INSERT INTO "public"."roffice_contract" VALUES ('49', null, null, null, null, null, null, null, '0001-01-01 00:00:00', 'ZT-JC-2015012', null, '2e+006', null, '777606', '0.279955', '', '辽源市人防办', '中天', null, ' 辽源市地下人防指挥所改建工程信息系统项目建设合同 ', '2.77761e+006', '800000', '合同签定后，开始进行综合布线施工，付首期款，人民币：捌拾万元整 ， 小写￥800，000元；
综合布线施工完成，设备开始安装后，支付乙方总计：人民币：柒拾万元整，小写￥700，000元；
工程完工，甲方验收合格后支付乙方总计：人民币：壹佰壹拾叁万捌仟柒佰贰拾伍元柒角整；小写  1138725.7 元；
质量保证金为合同总价款的  5  %，即人民币： 壹拾叁万捌仟捌佰捌拾元叁角     整，小写   138880.3  元；经甲方验收合格，设备正常运行一年后返还
', '2.77761e+006', '李鑫', '系统集成');
INSERT INTO "public"."roffice_contract" VALUES ('50', null, null, null, null, null, null, null, null, 'ZT-JC-2015011', null, '4400', null, '677880', '0.993551', '', '吉林省公安厅', '中天', null, '吉林省公安厅门禁一卡通项目', '682280', '0', '', '682280', '李鑫', '系统集成');
INSERT INTO "public"."roffice_contract" VALUES ('51', null, null, null, null, null, null, null, null, '', null, '0', null, '2.65334e+006', '1', '', '吉林省畜牧局', '中天', null, '吉林省畜牧业管理局（本级）畜产品质量安全追溯监管信息平台', '2.65334e+006', '0', '', '2.65334e+006', '程磊', '软件开发');
INSERT INTO "public"."roffice_contract" VALUES ('52', null, null, null, null, null, null, null, '0001-01-01 00:00:00', 'ZT-JC-2015012', null, '300000', null, '234195', '0.438407', '', '临江市人防', '中天', null, '临江市人防办地面指挥中心建设项目', '534195', '0', '合同签订后3个工作日内甲方支付给乙方合同额的70%，即人民币：叁拾柒万叁仟玖佰叁拾陆元整， 即￥373,936元；
 产品安装调试完毕并经甲方验收合格后5-10个工作日内支付尾款给乙方总计：即人民币：壹拾陆万零贰佰伍拾玖元整 ，即￥160,259 元
', '534195', '程磊', '系统集成');
INSERT INTO "public"."roffice_contract" VALUES ('53', null, null, null, null, null, null, null, '0001-01-01 00:00:00', 'ZT-JF-2015006', null, '200000', null, '80000', '0.285714', '', '吉林省林业信息中心', '中天', null, '吉林省林业信息中心设备维护服务项目 ', '280000', '0', '签订合同后，一次性付款', '280000', '程磊', '技术服务');
INSERT INTO "public"."roffice_contract" VALUES ('54', null, null, null, null, null, null, null, '0001-01-01 00:00:00', 'ZT-JF-2015008', null, '0', null, '60000', '1', '', '吉林省林业信息中心', '中天', null, '吉林省林业信息中心设备维护服务项目    ', '60000', '0', '签订合同后，一次性付款', '60000', '程磊', '技术服务');
INSERT INTO "public"."roffice_contract" VALUES ('55', null, null, null, null, null, null, null, '0001-01-01 00:00:00', 'ZT-XS-2015018', null, '1.52368e+006', null, '173866', '0.102422', '', '北京国电通网络技术有限公司', '中天', null, '国家电网公司流量分析系统项目', '1.69755e+006', '0', ' 本合同付款方式为6个月银行承兑汇票。', '1.69755e+006', '彭程', '系统集成');
INSERT INTO "public"."roffice_contract" VALUES ('56', null, null, null, null, null, null, null, '0001-01-01 00:00:00', 'ZT-XS-2015019', null, '168168', null, '119432', '0.415271', '', '秒创（北京）科技有限公司', '中天', null, '秒创（北京）科技有限公司设备销售', '287600', '0', '合同签订后一次性付款', '287600', '彭程', '系统集成');
INSERT INTO "public"."roffice_contract" VALUES ('57', null, null, null, null, null, null, null, null, 'ZT-JC-2015006', null, '5.66e+006', null, '9e+006', '0.613915', '', '吉林省食品药品信息中心(吉林省食品药品举报中心)', '中天', null, '
 吉林省食品药品放心工程信息管理系统及电子追溯信息平台扩建项目
', '1.466e+007', '0', '', '1.466e+007', '彭程', '系统集成');

-- ----------------------------
-- Table structure for roffice_contract_detail
-- ----------------------------
DROP TABLE IF EXISTS "public"."roffice_contract_detail";
CREATE TABLE "public"."roffice_contract_detail" (
"id" int8 NOT NULL,
"createby" varchar(255) COLLATE "default",
"creationdate" timestamp(6),
"updateby" varchar(255) COLLATE "default",
"updatedate" timestamp(6),
"version_" int8,
"adddate" timestamp(6),
"additional" bool NOT NULL,
"amount" int4 NOT NULL,
"brand" varchar(255) COLLATE "default",
"contractid" int4,
"name" varchar(255) COLLATE "default",
"price" float4 NOT NULL,
"provider" varchar(255) COLLATE "default",
"type" varchar(255) COLLATE "default",
"unit" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of roffice_contract_detail
-- ----------------------------

-- ----------------------------
-- Table structure for roffice_deploy
-- ----------------------------
DROP TABLE IF EXISTS "public"."roffice_deploy";
CREATE TABLE "public"."roffice_deploy" (
"id" int8 NOT NULL,
"createby" varchar(255) COLLATE "default",
"creationdate" timestamp(6),
"updateby" varchar(255) COLLATE "default",
"updatedate" timestamp(6),
"version_" int8,
"budget" varchar(255) COLLATE "default",
"comment" varchar(255) COLLATE "default",
"deployperson" varchar(255) COLLATE "default",
"finishinfo" varchar(255) COLLATE "default",
"measure" varchar(255) COLLATE "default",
"member" varchar(255) COLLATE "default",
"name" varchar(255) COLLATE "default",
"no" varchar(255) COLLATE "default",
"plan" varchar(255) COLLATE "default",
"problem" varchar(255) COLLATE "default",
"projectid" int8 NOT NULL,
"receiveinfo" varchar(255) COLLATE "default",
"saleperson" varchar(255) COLLATE "default",
"status" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of roffice_deploy
-- ----------------------------

-- ----------------------------
-- Table structure for roffice_invoice
-- ----------------------------
DROP TABLE IF EXISTS "public"."roffice_invoice";
CREATE TABLE "public"."roffice_invoice" (
"id" int8 NOT NULL,
"createby" varchar(255) COLLATE "default",
"creationdate" timestamp(6),
"updateby" varchar(255) COLLATE "default",
"updatedate" timestamp(6),
"version_" int8,
"contractid" int4,
"invoicedate" timestamp(6),
"invoiceno" varchar(255) COLLATE "default",
"money" float4,
"rate" float4
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of roffice_invoice
-- ----------------------------

-- ----------------------------
-- Table structure for roffice_news
-- ----------------------------
DROP TABLE IF EXISTS "public"."roffice_news";
CREATE TABLE "public"."roffice_news" (
"id" int8 NOT NULL,
"createby" varchar(255) COLLATE "default",
"creationdate" timestamp(6),
"updateby" varchar(255) COLLATE "default",
"updatedate" timestamp(6),
"version_" int8,
"content" varchar(255) COLLATE "default",
"publishdate" timestamp(6),
"publishpeople" varchar(255) COLLATE "default",
"title" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of roffice_news
-- ----------------------------

-- ----------------------------
-- Table structure for roffice_note
-- ----------------------------
DROP TABLE IF EXISTS "public"."roffice_note";
CREATE TABLE "public"."roffice_note" (
"id" int8 NOT NULL,
"createby" varchar(255) COLLATE "default",
"creationdate" timestamp(6),
"updateby" varchar(255) COLLATE "default",
"updatedate" timestamp(6),
"version_" int8,
"content" varchar(255) COLLATE "default",
"name" varchar(255) COLLATE "default",
"publishdate" timestamp(6),
"publishpeople" varchar(255) COLLATE "default",
"title" varchar(255) COLLATE "default",
"rating" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of roffice_note
-- ----------------------------
INSERT INTO "public"."roffice_note" VALUES ('25310', null, '2015-12-02 11:02:44.361', null, '2015-12-02 16:51:02.052', '3', '1.调整销售管理内容菜单内容；
2.任务目标统计功能增强，增加合计和小计。
3.统计报表增加权限控制。
4.列表中可以双击查看。
5.修改合同列表显示数据项。', '协同办公内容更新20151202', '2015-12-02 11:02:44', '管理员', null, '3');

-- ----------------------------
-- Table structure for roffice_pay
-- ----------------------------
DROP TABLE IF EXISTS "public"."roffice_pay";
CREATE TABLE "public"."roffice_pay" (
"id" int8 NOT NULL,
"createby" varchar(255) COLLATE "default",
"creationdate" timestamp(6),
"updateby" varchar(255) COLLATE "default",
"updatedate" timestamp(6),
"version_" int8,
"content" varchar(255) COLLATE "default",
"name" varchar(255) COLLATE "default",
"publishdate" timestamp(6),
"publishpeople" varchar(255) COLLATE "default",
"title" varchar(255) COLLATE "default",
"comment" varchar(255) COLLATE "default",
"money" float4,
"purchaseid" int8 NOT NULL,
"receivedate" timestamp(6)
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of roffice_pay
-- ----------------------------

-- ----------------------------
-- Table structure for roffice_project
-- ----------------------------
DROP TABLE IF EXISTS "public"."roffice_project";
CREATE TABLE "public"."roffice_project" (
"id" int8 NOT NULL,
"createby" varchar(255) COLLATE "default",
"creationdate" timestamp(6),
"updateby" varchar(255) COLLATE "default",
"updatedate" timestamp(6),
"version_" int8,
"budget" varchar(255) COLLATE "default",
"chanceid" int8 NOT NULL,
"client" varchar(255) COLLATE "default",
"clientphone" varchar(255) COLLATE "default",
"comment" varchar(255) COLLATE "default",
"contractid" int8 NOT NULL,
"deploydate" timestamp(6),
"deployperson" varchar(255) COLLATE "default",
"description" varchar(255) COLLATE "default",
"industry" varchar(255) COLLATE "default",
"level" varchar(255) COLLATE "default",
"manager" varchar(255) COLLATE "default",
"name" varchar(255) COLLATE "default",
"no" varchar(255) COLLATE "default",
"saleperson" varchar(255) COLLATE "default",
"setupdate" timestamp(6),
"status" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of roffice_project
-- ----------------------------
INSERT INTO "public"."roffice_project" VALUES ('313', null, '2015-11-12 01:22:38.753', null, '2015-11-12 01:22:38.754', '6', '1', '266', '', '', '', '0', '2015-11-26 08:00:00', '管理员2', '', '', '中', '管理员2', 'aello', '2323', '管理员2', '2015-11-17 08:00:00', '1');
INSERT INTO "public"."roffice_project" VALUES ('18210', null, '2015-11-22 01:26:09.41', null, '2015-11-22 02:45:08.536', '9', '0', '1830', '', '', '', '1842', '2015-11-25 00:00:00', '高冠男', '', '', '中', '孙凌峰', '222222222', '22222222222', 'ds', '2015-11-23 00:00:00', '1');

-- ----------------------------
-- Table structure for roffice_projectwe
-- ----------------------------
DROP TABLE IF EXISTS "public"."roffice_projectwe";
CREATE TABLE "public"."roffice_projectwe" (
"id" int8 NOT NULL,
"createby" varchar(255) COLLATE "default",
"creationdate" timestamp(6),
"updateby" varchar(255) COLLATE "default",
"updatedate" timestamp(6),
"budget" varchar(255) COLLATE "default",
"chanceid" int8,
"client" varchar(255) COLLATE "default",
"clientphone" varchar(255) COLLATE "default",
"comment" varchar(255) COLLATE "default",
"contractid" int8,
"deploydate" timestamp(6),
"deployperson" varchar(255) COLLATE "default",
"description" varchar(255) COLLATE "default",
"industry" varchar(255) COLLATE "default",
"level" varchar(255) COLLATE "default",
"manager" varchar(255) COLLATE "default",
"name" varchar(255) COLLATE "default",
"no" varchar(255) COLLATE "default",
"saleperson" varchar(255) COLLATE "default",
"setupdate" timestamp(6),
"status" varchar(255) COLLATE "default",
"version_" int8
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of roffice_projectwe
-- ----------------------------

-- ----------------------------
-- Table structure for roffice_purchaseinvoice
-- ----------------------------
DROP TABLE IF EXISTS "public"."roffice_purchaseinvoice";
CREATE TABLE "public"."roffice_purchaseinvoice" (
"id" int8 NOT NULL,
"createby" varchar(255) COLLATE "default",
"creationdate" timestamp(6),
"updateby" varchar(255) COLLATE "default",
"updatedate" timestamp(6),
"version_" int8,
"comment" varchar(255) COLLATE "default",
"invoicedate" timestamp(6),
"invoiceno" varchar(255) COLLATE "default",
"money" float4,
"purchaseid" int8 NOT NULL,
"rate" float4
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of roffice_purchaseinvoice
-- ----------------------------

-- ----------------------------
-- Table structure for roffice_receive
-- ----------------------------
DROP TABLE IF EXISTS "public"."roffice_receive";
CREATE TABLE "public"."roffice_receive" (
"id" int8 NOT NULL,
"createby" varchar(255) COLLATE "default",
"creationdate" timestamp(6),
"updateby" varchar(255) COLLATE "default",
"updatedate" timestamp(6),
"comment" varchar(255) COLLATE "default",
"contractid" int8,
"contractnumber" varchar(255) COLLATE "default",
"money" float4,
"receivedate" timestamp(6),
"version_" int8
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of roffice_receive
-- ----------------------------
INSERT INTO "public"."roffice_receive" VALUES ('1', null, null, null, null, '（1）买方收到卖方开具的合同金额的全款增值税专用发票后，以银行承兑汇票方式支付卖方1872000.00元，大写：壹佰捌拾柒万贰仟元整，银行承兑日期为收到发票之日起180天。
（2）买方收到最终用户全款后，以电汇形式支付余款100000.00元，大写：十万元整
', null, 'ZT-XS-2015001', '1.872e+006', null, null);
INSERT INTO "public"."roffice_receive" VALUES ('2', null, null, null, null, '项目验收三日内，支付全部合同金额1,397,917元', null, 'ZT-JC-2015001', '1.39792e+006', null, null);
INSERT INTO "public"."roffice_receive" VALUES ('3', null, null, null, null, '合同签定后，需方收到货3日内向供方支付合同全部价款（即人民币：17064元，大写：壹万柒仟零陆拾肆元整）', null, 'ZT-XS-2015002', '33602', null, null);
INSERT INTO "public"."roffice_receive" VALUES ('4', null, null, null, null, '一次性付清', null, 'ZT-XS-2015004', '3500', null, null);
INSERT INTO "public"."roffice_receive" VALUES ('5', null, null, null, null, '', null, 'ZT-XS-2015005', '0', null, null);
INSERT INTO "public"."roffice_receive" VALUES ('6', null, null, null, null, '需方收到货三日内支付全部合同款 49636元。', null, 'ZT-XS-2015006', '54516', null, null);
INSERT INTO "public"."roffice_receive" VALUES ('7', null, null, null, null, '一次性付清', null, 'ZT-JF-2015001', '200000', null, null);
INSERT INTO "public"."roffice_receive" VALUES ('8', null, null, null, null, '签订合同后一次性付清全部合同额，即小写：15000元', null, 'ZT-JF-2015002', '15000', null, null);
INSERT INTO "public"."roffice_receive" VALUES ('9', null, null, null, null, '项目验收合格后，三日内甲方支付乙方全部合同款', null, 'LC-JK-2015001', '0', null, null);
INSERT INTO "public"."roffice_receive" VALUES ('10', null, null, null, null, '甲方在收到发票后7日内支付给乙方合同总价的100％', null, 'ZT-XS-2015007', '12849', null, null);
INSERT INTO "public"."roffice_receive" VALUES ('11', null, null, null, null, '1) 甲方在合同签订后14日内向乙方支付合同总金额的30％ 作为预付款。
2) 乙方将本合同项下全部设备运抵甲方指定地点并完成验收后，甲方支付到合同总金额的80％。
3) 交工验收合格后14个工作日内，甲方支付到合同总金额的100％。
', null, 'ZT-XS-2015008', '4.98e+006', null, null);
INSERT INTO "public"."roffice_receive" VALUES ('12', null, null, null, null, '', null, 'RX-JF-2015001', '0', null, null);
INSERT INTO "public"."roffice_receive" VALUES ('13', null, null, null, null, '技术服务费由甲方一次性支付乙方', null, 'ZT-JF-2015003', '120000', null, null);
INSERT INTO "public"."roffice_receive" VALUES ('14', null, null, null, null, '合同签署后甲方以电汇方式支付乙方20%货款，甲方收到货物及全额发票2个月内，甲方以电汇方式支付乙方80%货款。', null, 'RX-XS-2015001', '3.95e+006', null, null);
INSERT INTO "public"."roffice_receive" VALUES ('15', null, null, null, null, '合同签署后甲方以电汇方式支付乙方20%货款，甲方收到货物及全额发票2个月内，甲方以电汇方式支付乙方80%货款。', null, 'RX-XS-2015001(1)', '300000', null, null);
INSERT INTO "public"."roffice_receive" VALUES ('16', null, null, null, null, '合同签订后3个工作日内甲方支付给乙方合同额的70%，产品安装调试完毕并经甲方验收合格后5-10个工作日内支付尾款给乙方。', null, 'ZT-GC-2015001', '482284', null, null);
INSERT INTO "public"."roffice_receive" VALUES ('17', null, null, null, null, '合同签定后，30日内将货物保质保量发出，需方收到货3日内向供方支付合同全部价款。', null, 'ZT-GC-2015002', '0', null, null);
INSERT INTO "public"."roffice_receive" VALUES ('18', null, null, null, null, '验收合格后一次性付全款', null, 'ZT-XS-2015010', '57000', null, null);
INSERT INTO "public"."roffice_receive" VALUES ('19', null, null, null, null, '甲方与乙方签订合同后7工作日内，将合同总额以人民币形式汇至乙方指定的银行账户。', null, 'ZT-JF-2015004', '49800', null, null);
INSERT INTO "public"."roffice_receive" VALUES ('20', null, null, null, null, '合同签署后甲方以电汇方式支付乙方10%货款，甲方收到货物及全额发票2个月内，甲方以电汇方式支付乙方90%货款。', null, 'RX-XS-2015003', '740713', null, null);
INSERT INTO "public"."roffice_receive" VALUES ('21', null, null, null, null, '财政厅收到合同约定付款文件后15个工作日内，采用银行转账方式将合同价款中财政付款金额一次性支付给供方。', null, 'ZT-JC-2015004', '395000', null, null);
INSERT INTO "public"."roffice_receive" VALUES ('22', null, null, null, null, '合同签订后3日内，一次性付清全部合同款。', null, 'ZT-JF-2015005', '0', null, null);
INSERT INTO "public"."roffice_receive" VALUES ('23', null, null, null, null, '', null, 'ZT-GC-2015003', '9216', null, null);
INSERT INTO "public"."roffice_receive" VALUES ('24', null, null, null, null, '', null, 'ZT-GC-2015004', '23040', null, null);
INSERT INTO "public"."roffice_receive" VALUES ('25', null, null, null, null, '合同签订后3个工作日内甲方支付给乙方合同额的70%，1046500元，产品安装调试完毕并经甲方验收合格后5-10个工作日内支付尾款给乙方。448500元', null, 'RX-JK-2015002', '1.0465e+006', null, null);
INSERT INTO "public"."roffice_receive" VALUES ('26', null, null, null, null, '本合同的付款方式为：合同签订后，合同货物全部到达指定地点后支付合同金额50%，即：叁佰柒拾贰万肆仟零伍拾元整（小写：3724050.00），安装调试验收合格后15个工作日支付合同全部余款的45%，即：叁佰叁拾伍万壹仟陆佰肆拾伍元整（小写：3351645.00），剩余的5%合同金额即叁拾柒万贰仟肆佰零伍元（小写：372，405.00）作为产品质保金，保证期为1年。', null, 'ZT-JC-2015005', '3.72405e+006', null, null);
INSERT INTO "public"."roffice_receive" VALUES ('27', null, null, null, null, '到货后一次性付款', null, 'ZT-XS-2015013', '0', null, null);
INSERT INTO "public"."roffice_receive" VALUES ('28', null, null, null, null, '到货后一次性付款', null, 'ZT-XS-2015011', '0', null, null);
INSERT INTO "public"."roffice_receive" VALUES ('29', null, null, null, null, '一次性付款', null, 'ZT-XS-2015014', '0', null, null);
INSERT INTO "public"."roffice_receive" VALUES ('30', null, null, null, null, '初验收支付合同额的70%,即142450元，终验后支付20%即40700元，验收后运行稳定一个月后支付剩余10%，即20350元。', null, 'RX-JK-2015003', '0', null, null);
INSERT INTO "public"."roffice_receive" VALUES ('31', null, null, null, null, '验收后一次性支付', null, 'RX-JF-2015003', '0', null, null);
INSERT INTO "public"."roffice_receive" VALUES ('33', null, null, null, null, '一次性付款', null, 'ZT-XS-2015015', '32300', null, null);
INSERT INTO "public"."roffice_receive" VALUES ('34', null, null, null, null, '一次性付款', null, 'RX-JF-2015002', '50000', null, null);
INSERT INTO "public"."roffice_receive" VALUES ('35', null, null, null, null, '上线款：本合同约定的标的服务完全实现，且上线后3日内由乙方开具付款通知单，甲方收到付款通知单后10日向乙方支付；
初验款：乙方完成数据优化服务工作后，经甲方初验后，支付合同总价的30%；
终验款：乙方完成全部数据优化服务工作，并提交服务资料档案相关数据，经甲方验收通过后10个工作日内，甲方向乙方支付补充合同总价的20%。', null, 'ZT-JF-2015007', '0', null, null);
INSERT INTO "public"."roffice_receive" VALUES ('36', null, null, null, null, '签订合同开具发票后，一次性支付全部合同款。', null, 'ZT-XS-2015016', '19850', null, null);
INSERT INTO "public"."roffice_receive" VALUES ('37', null, null, null, null, '设备到货验收合格后15个工作日内支付50%，即326000元，安装调试验收合格后15个工作日内支付剩余50%，即3260000元', null, 'ZT-JC-2015009', '0', null, null);
INSERT INTO "public"."roffice_receive" VALUES ('41', null, null, null, null, '签订合同3日内支付70%，即695495.36元，验收后5-10个工作日支付剩余30%，即298069.43元', null, 'ZT-GC-2015005', '695495', null, null);
INSERT INTO "public"."roffice_receive" VALUES ('42', null, null, null, null, '', null, 'ZT-JK-2015001', '750000', null, null);
INSERT INTO "public"."roffice_receive" VALUES ('43', null, null, null, null, '合同验收合格后5个工作日内，向省财政厅提交约定的付款文件，采购办收到付款文件后15个工作日内，一次性支付。', null, 'ZT-JC-2015010', '0', null, null);
INSERT INTO "public"."roffice_receive" VALUES ('44', null, null, null, null, '', null, 'ZT-XS-2015012', '99400', null, null);
INSERT INTO "public"."roffice_receive" VALUES ('47', null, null, null, null, '', null, '', '0', null, null);
INSERT INTO "public"."roffice_receive" VALUES ('48', null, null, null, null, '', null, 'ZT-XS-2015017', '0', null, null);
INSERT INTO "public"."roffice_receive" VALUES ('49', null, null, null, null, '合同签定后，开始进行综合布线施工，付首期款，人民币：捌拾万元整 ， 小写￥800，000元；
综合布线施工完成，设备开始安装后，支付乙方总计：人民币：柒拾万元整，小写￥700，000元；
工程完工，甲方验收合格后支付乙方总计：人民币：壹佰壹拾叁万捌仟柒佰贰拾伍元柒角整；小写  1138725.7 元；
质量保证金为合同总价款的  5  %，即人民币： 壹拾叁万捌仟捌佰捌拾元叁角     整，小写   138880.3  元；经甲方验收合格，设备正常运行一年后返还
', null, 'ZT-JC-2015012', '800000', null, null);
INSERT INTO "public"."roffice_receive" VALUES ('50', null, null, null, null, '', null, 'ZT-JC-2015011', '0', null, null);
INSERT INTO "public"."roffice_receive" VALUES ('52', null, null, null, null, '合同签订后3个工作日内甲方支付给乙方合同额的70%，即人民币：叁拾柒万叁仟玖佰叁拾陆元整， 即￥373,936元；
 产品安装调试完毕并经甲方验收合格后5-10个工作日内支付尾款给乙方总计：即人民币：壹拾陆万零贰佰伍拾玖元整 ，即￥160,259 元
', null, 'ZT-JC-2015012', '0', null, null);
INSERT INTO "public"."roffice_receive" VALUES ('53', null, null, null, null, '签订合同后，一次性付款', null, 'ZT-JF-2015006', '0', null, null);
INSERT INTO "public"."roffice_receive" VALUES ('54', null, null, null, null, '签订合同后，一次性付款', null, 'ZT-JF-2015008', '0', null, null);
INSERT INTO "public"."roffice_receive" VALUES ('55', null, null, null, null, ' 本合同付款方式为6个月银行承兑汇票。', null, 'ZT-XS-2015018', '0', null, null);
INSERT INTO "public"."roffice_receive" VALUES ('56', null, null, null, null, '合同签订后一次性付款', null, 'ZT-XS-2015019', '0', null, null);
INSERT INTO "public"."roffice_receive" VALUES ('57', null, null, null, null, '', null, 'ZT-JC-2015006', '0', null, null);

-- ----------------------------
-- Table structure for roffice_support
-- ----------------------------
DROP TABLE IF EXISTS "public"."roffice_support";
CREATE TABLE "public"."roffice_support" (
"id" int8 NOT NULL,
"createby" varchar(255) COLLATE "default",
"creationdate" timestamp(6),
"updateby" varchar(255) COLLATE "default",
"updatedate" timestamp(6),
"version_" int8,
"content" varchar(255) COLLATE "default",
"publishdate" timestamp(6),
"publishpeople" varchar(255) COLLATE "default",
"title" varchar(255) COLLATE "default",
"billdate" timestamp(6),
"budget" varchar(255) COLLATE "default",
"chanceid" int8 NOT NULL,
"comment" varchar(255) COLLATE "default",
"industry" varchar(255) COLLATE "default",
"level" varchar(255) COLLATE "default",
"name" varchar(255) COLLATE "default",
"saler" varchar(255) COLLATE "default",
"startdate" timestamp(6),
"subsystem" varchar(255) COLLATE "default",
"supportperson" varchar(255) COLLATE "default",
"supporter" varchar(255) COLLATE "default",
"type" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of roffice_support
-- ----------------------------

-- ----------------------------
-- Table structure for roffice_task
-- ----------------------------
DROP TABLE IF EXISTS "public"."roffice_task";
CREATE TABLE "public"."roffice_task" (
"id" int8 NOT NULL,
"createby" varchar(255) COLLATE "default",
"creationdate" timestamp(6),
"updateby" varchar(255) COLLATE "default",
"updatedate" timestamp(6),
"contactno" float4,
"name" varchar(255) COLLATE "default",
"targetno" float4,
"tasktype" varchar(255) COLLATE "default",
"year" varchar(255) COLLATE "default",
"version_" int8,
"percent" float4,
"contactpercent" float4,
"finishcontactno" float4,
"finishtargetno" float4,
"targetpercent" float4
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of roffice_task
-- ----------------------------
INSERT INTO "public"."roffice_task" VALUES ('1', null, null, null, null, '5.32e+006', '彭程', '1.26e+006', '软件开发', '2015', null, '0.2', '0.533835', '2.84e+006', '968000', '0.768254');
INSERT INTO "public"."roffice_task" VALUES ('2', null, null, null, null, '3.23e+007', '彭程', '7.65e+006', '系统集成', '2015', null, '0.3', '0.999816', '3.22941e+007', '1.00268e+007', '1.31069');
INSERT INTO "public"."roffice_task" VALUES ('3', null, null, null, null, '380000', '彭程', '90000', '技术服务', '2015', null, '0.12', '1.23632', '469800', '45800', '0.508889');
INSERT INTO "public"."roffice_task" VALUES ('4', null, null, null, null, '7.7e+006', '余娜', '1.12e+006', '软件开发', '2015', null, null, '0.291558', '2.245e+006', '1.4773e+006', '1.31902');
INSERT INTO "public"."roffice_task" VALUES ('5', null, null, null, null, '4.675e+007', '余娜', '6.8e+006', '系统集成', '2015', null, null, '0.023461', '1.0968e+006', '469100', '0.0689853');
INSERT INTO "public"."roffice_task" VALUES ('6', null, null, null, null, '550000', '余娜', '80000', '技术服务', '2015', null, null, '0.607273', '334000', '334000', '4.175');
INSERT INTO "public"."roffice_task" VALUES ('7', null, null, null, null, '1.4e+006', '曹璐', '700000', '软件开发', '2015', null, null, '0.0635714', '89000', '89000', '0.127143');
INSERT INTO "public"."roffice_task" VALUES ('8', null, null, null, null, '8.5e+006', '曹璐', '4.25e+006', '系统集成', '2015', null, null, '1.35294', '1.15e+007', '4.97323e+006', '1.17017');
INSERT INTO "public"."roffice_task" VALUES ('9', null, null, null, null, '100000', '曹璐', '50000', '技术服务', '2015', null, null, null, null, null, null);
INSERT INTO "public"."roffice_task" VALUES ('10', null, null, null, null, '1.4e+006', '程磊', '700000', '软件开发', '2015', null, null, '1.89525', '2.65334e+006', '2.65334e+006', '3.79049');
INSERT INTO "public"."roffice_task" VALUES ('11', null, null, null, null, '8.5e+006', '程磊', '4.25e+006', '系统集成', '2015', null, null, '0.0628465', '534195', '234195', '0.0551047');
INSERT INTO "public"."roffice_task" VALUES ('12', null, null, null, null, '100000', '程磊', '50000', '技术服务', '2015', null, null, '3.4', '340000', '140000', '2.8');
INSERT INTO "public"."roffice_task" VALUES ('13', null, null, null, null, '700000', '李鑫', '420000', '软件开发', '2015', null, null, '0.290714', '203500', '18500', '0.0440476');
INSERT INTO "public"."roffice_task" VALUES ('14', null, null, null, null, '4.25e+006', '李鑫', '2.55e+006', '系统集成', '2015', null, null, '1.42495', '6.05602e+006', '2.09548e+006', '0.821756');
INSERT INTO "public"."roffice_task" VALUES ('15', null, null, null, null, '50000', '李鑫', '30000', '技术服务', '2015', null, null, '2.22', '111000', '109520', '3.65067');

-- ----------------------------
-- Table structure for roffice_travel
-- ----------------------------
DROP TABLE IF EXISTS "public"."roffice_travel";
CREATE TABLE "public"."roffice_travel" (
"id" int8 NOT NULL,
"createby" varchar(255) COLLATE "default",
"creationdate" timestamp(6),
"updateby" varchar(255) COLLATE "default",
"updatedate" timestamp(6),
"version_" int8,
"content" varchar(255) COLLATE "default",
"publishdate" timestamp(6),
"publishpeople" varchar(255) COLLATE "default",
"title" varchar(255) COLLATE "default",
"comment" varchar(255) COLLATE "default",
"enddate" timestamp(6),
"name" varchar(255) COLLATE "default",
"person" varchar(255) COLLATE "default",
"result" varchar(255) COLLATE "default",
"resultperson" varchar(255) COLLATE "default",
"startdate" timestamp(6),
"target" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of roffice_travel
-- ----------------------------

-- ----------------------------
-- Table structure for sys_about
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_about";
CREATE TABLE "public"."sys_about" (
"id" int8 NOT NULL,
"createby" varchar(255) COLLATE "default",
"creationdate" timestamp(6),
"updateby" varchar(255) COLLATE "default",
"updatedate" timestamp(6),
"version_" int8,
"code" varchar(255) COLLATE "default",
"jd" varchar(255) COLLATE "default",
"systemname" varchar(255) COLLATE "default",
"systemversion" varchar(255) COLLATE "default",
"username" varchar(255) COLLATE "default",
"wd" varchar(255) COLLATE "default",
"xzqh_dm" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of sys_about
-- ----------------------------

-- ----------------------------
-- Table structure for sys_application
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_application";
CREATE TABLE "public"."sys_application" (
"id" int8 NOT NULL,
"createby" varchar(255) COLLATE "default",
"creationdate" timestamp(6),
"updateby" varchar(255) COLLATE "default",
"updatedate" timestamp(6),
"version_" int8,
"code" varchar(255) COLLATE "default" NOT NULL,
"location" varchar(255) COLLATE "default",
"name" varchar(255) COLLATE "default" NOT NULL,
"remark" varchar(255) COLLATE "default" NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of sys_application
-- ----------------------------
INSERT INTO "public"."sys_application" VALUES ('58', '管理员', '2015-11-16 16:13:12.556', '管理员', '2015-11-16 16:13:12.556', '0', 'roffice', '', '协同办公', '');
INSERT INTO "public"."sys_application" VALUES ('7901', null, '2015-08-14 09:02:40', '管理员2', '2015-08-14 09:02:40', '16', 'admin', '', '系统应用', '顶部导航栏');
INSERT INTO "public"."sys_application" VALUES ('12501', '管理员2', '2015-08-14 09:02:44', '管理员2', '2015-08-14 09:02:44', '5', 'workflow', '', '测试应用', '');

-- ----------------------------
-- Table structure for sys_area
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_area";
CREATE TABLE "public"."sys_area" (
"id" int8 NOT NULL,
"createby" varchar(255) COLLATE "default",
"creationdate" timestamp(6),
"updateby" varchar(255) COLLATE "default",
"updatedate" timestamp(6),
"version_" int8,
"centercode" varchar(255) COLLATE "default",
"code" varchar(255) COLLATE "default",
"isleaf" int4 NOT NULL,
"jd" varchar(255) COLLATE "default",
"name" varchar(255) COLLATE "default",
"parentid" int8 NOT NULL,
"parentids" varchar(255) COLLATE "default",
"type" varchar(255) COLLATE "default",
"wd" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of sys_area
-- ----------------------------
INSERT INTO "public"."sys_area" VALUES ('1', null, '2015-07-30 16:22:49', '管理员', '2015-07-30 16:22:49', '4', '22', '22', '0', '', '吉林省', '-1', null, null, '');
INSERT INTO "public"."sys_area" VALUES ('2', null, '2015-07-30 14:37:36', '管理员', '2015-07-30 14:37:36', '2', '220101', '220101', '1', '', '市辖区', '12', null, null, '');
INSERT INTO "public"."sys_area" VALUES ('3', null, null, 'fdad2222', '2015-07-24 16:06:29', '2', '220102', '220102', '1', '', '南关区', '12', null, null, '');
INSERT INTO "public"."sys_area" VALUES ('4', null, null, null, null, '1', null, '220103', '1', null, '宽城区', '12', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('5', null, null, null, null, '1', null, '220104', '1', null, '朝阳区', '12', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('6', null, null, null, null, '1', null, '220105', '1', null, '二道区', '12', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('7', null, null, null, null, '1', null, '220106', '1', null, '绿园区', '12', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('8', null, null, null, null, '1', null, '220112', '1', null, '双阳区', '12', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('9', null, null, null, null, '1', null, '220113', '1', null, '经济技术开发区', '12', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('10', null, null, null, null, '1', null, '220114', '1', null, '高新技术开发区', '12', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('11', null, null, null, null, '1', null, '220115', '1', null, '净月旅游开发区', '12', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('12', null, '2015-07-30 16:22:26', '张三', '2015-07-30 16:22:26', '6', '2201', '2201', '0', '', '长春市', '1', null, null, '');
INSERT INTO "public"."sys_area" VALUES ('13', null, null, null, null, '1', null, '2202', '0', null, '吉林市', '1', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('14', null, null, null, null, '1', null, '2203', '0', '124.356312', '四平市', '1', null, null, '43.17279');
INSERT INTO "public"."sys_area" VALUES ('15', null, null, null, null, '1', null, '2204', '0', '125.123912', '辽源市', '1', null, null, '42.924993');
INSERT INTO "public"."sys_area" VALUES ('16', null, null, null, null, '1', null, '2205', '0', null, '通化市', '1', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('17', null, null, null, null, '1', null, '2206', '0', null, '白山市', '1', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('18', null, null, null, null, '1', null, '2207', '0', null, '松原市', '1', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('19', null, null, null, null, '1', null, '2208', '0', '122.846239', '白城市', '1', null, null, '45.626834');
INSERT INTO "public"."sys_area" VALUES ('20', null, null, null, null, '1', null, '2224', '0', '129.516947', '延边朝鲜族自治州', '1', null, null, '43.508571');
INSERT INTO "public"."sys_area" VALUES ('21', null, null, null, null, '1', null, '2222', '0', null, '长白山管委会', '1', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('22', null, null, null, null, '1', null, '220116', '1', null, '汽车产业开发区', '12', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('23', null, null, null, null, '1', null, '220122', '1', null, '农安县', '12', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('24', null, null, null, null, '1', null, '220181', '1', null, '九台市', '12', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('25', null, null, null, null, '1', null, '220182', '1', null, '榆树市', '12', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('26', null, null, null, null, '1', null, '220183', '1', null, '德惠市', '12', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('27', null, null, null, null, '1', null, '220201', '1', null, '市辖区', '13', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('28', null, null, null, null, '1', null, '220202', '1', null, '昌邑区', '13', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('29', null, null, null, null, '1', null, '220203', '1', null, '龙潭区', '13', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('30', null, null, null, null, '1', null, '220204', '1', null, '船营区', '13', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('31', null, null, null, null, '1', null, '220211', '1', null, '丰满区', '13', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('32', null, null, null, null, '1', null, '220212', '1', null, '经济技术开发区', '13', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('33', null, null, null, null, '1', null, '220213', '1', null, '高新技术开发区', '13', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('34', null, null, null, null, '1', null, '220214', '1', null, '北大壶开发区', '13', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('35', null, null, null, null, '1', null, '220221', '1', null, '永吉县', '13', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('36', null, null, null, null, '1', null, '220281', '1', null, '蛟河市', '13', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('37', null, null, null, null, '1', null, '220282', '1', null, '桦甸市', '13', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('38', null, null, null, null, '1', null, '220283', '1', null, '舒兰市', '13', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('39', null, null, null, null, '1', null, '220284', '1', null, '磐石市', '13', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('40', null, null, null, null, '1', null, '220301', '1', null, '市辖区', '14', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('41', null, null, null, null, '1', null, '220302', '1', null, '铁西区', '14', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('42', null, null, null, null, '1', null, '220303', '1', null, '铁东区', '14', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('43', null, null, null, null, '1', null, '220304', '1', null, '经济开发区', '14', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('44', null, null, null, null, '1', null, '220305', '1', null, '辽河农垦管理区', '14', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('45', null, null, null, null, '1', null, '220322', '1', null, '梨树县', '14', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('46', null, null, null, null, '1', null, '220323', '1', null, '伊通满族自治县', '14', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('47', null, null, null, null, '1', null, '220381', '1', '124.685882', '公主岭市', '14', null, null, '43.791826');
INSERT INTO "public"."sys_area" VALUES ('48', null, null, null, null, '1', null, '220382', '1', '123.708520', '双辽市', '14', null, null, '43.767694');
INSERT INTO "public"."sys_area" VALUES ('49', null, null, null, null, '1', null, '220401', '1', null, '市辖区', '15', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('50', null, null, null, null, '1', null, '220402', '1', null, '龙山区', '15', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('51', null, null, null, null, '1', null, '220403', '1', null, '西安区', '15', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('52', null, null, null, null, '1', null, '220404', '1', null, '经济开发区', '15', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('53', null, null, null, null, '1', null, '220421', '1', null, '东丰县', '15', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('54', null, null, null, null, '1', null, '220422', '1', null, '东辽县', '15', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('55', null, null, null, null, '1', null, '220501', '1', null, '市辖区', '16', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('56', null, null, null, null, '1', null, '220502', '1', null, '东昌区', '16', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('57', null, null, null, null, '1', null, '220503', '1', null, '二道江区', '16', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('58', null, null, null, null, '1', null, '220504', '1', null, '医药高新区', '16', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('59', null, null, null, null, '1', null, '220521', '1', null, '通化县', '16', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('60', null, null, null, null, '1', null, '220523', '1', null, '辉南县', '16', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('61', null, null, null, null, '1', null, '220524', '1', null, '柳河县', '16', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('62', null, null, null, null, '1', null, '220581', '1', null, '梅河口市', '16', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('63', null, null, null, null, '1', null, '220582', '1', null, '集安市', '16', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('64', null, null, null, null, '1', null, '220601', '1', null, '市辖区', '17', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('65', null, null, null, null, '1', null, '220602', '1', null, '浑江区', '17', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('66', null, null, null, null, '1', null, '220604', '1', null, '江源区', '17', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('67', null, null, null, null, '1', null, '220605', '1', null, '经济开发区', '17', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('68', null, null, null, null, '1', null, '220621', '1', null, '抚松县', '17', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('69', null, null, null, null, '1', null, '220622', '1', null, '靖宇县', '17', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('70', null, null, null, null, '1', null, '220623', '1', null, '长白朝鲜族自治县', '17', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('71', null, null, null, null, '1', null, '220625', '1', null, '江源县', '17', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('72', null, null, null, null, '1', null, '220681', '1', null, '临江市', '17', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('73', null, null, null, null, '1', null, '220701', '1', null, '市辖区', '18', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('74', null, null, null, null, '1', null, '220702', '1', null, '宁江区', '18', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('75', null, null, null, null, '1', null, '220721', '1', null, '前郭尔罗斯蒙古族自治', '18', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('76', null, null, null, null, '1', null, '220722', '1', null, '长岭县', '18', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('77', null, null, null, null, '1', null, '220723', '1', null, '乾安县', '18', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('78', null, null, null, null, '1', null, '220724', '1', null, '扶余市', '18', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('79', null, null, null, null, '1', null, '220725', '1', null, '经济开发区', '18', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('80', null, null, null, null, '1', null, '220726', '1', null, '石油化学工业循环经济', '18', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('81', null, null, null, null, '1', null, '220801', '1', null, '市辖区', '19', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('82', null, null, null, null, '1', null, '220802', '1', '122.842671', '洮北区', '19', null, null, '45.626718');
INSERT INTO "public"."sys_area" VALUES ('83', null, null, null, null, '1', null, '220803', '1', null, '查干浩特旅游开发区', '19', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('84', null, null, null, null, '1', null, '220804', '1', null, '经济开发区', '19', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('85', null, null, null, null, '1', null, '220821', '1', null, '镇赉县', '19', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('86', null, null, null, null, '1', null, '220822', '1', null, '通榆县', '19', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('87', null, null, null, null, '1', null, '220881', '1', null, '洮南市', '19', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('88', null, null, null, null, '1', null, '220882', '1', null, '大安市', '19', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('89', null, null, null, null, '1', null, '222201', '1', null, '池西区', '21', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('90', null, null, null, null, '1', null, '222202', '1', null, '池北区', '21', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('91', null, null, null, null, '1', null, '222203', '1', null, '池南区', '21', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('92', null, null, null, null, '1', null, '222401', '1', null, '延吉市', '20', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('93', null, null, null, null, '1', null, '222402', '1', null, '图们市', '20', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('94', null, null, null, null, '1', null, '222403', '1', null, '敦化市', '20', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('95', null, null, null, null, '1', null, '222404', '1', null, '珲春市', '20', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('96', null, null, null, null, '1', null, '222405', '1', '129.383816', '龙井市', '20', null, null, '42.844249');
INSERT INTO "public"."sys_area" VALUES ('97', null, null, null, null, '1', null, '222406', '1', '128.911210', '和龙市', '20', null, null, '42.466442');
INSERT INTO "public"."sys_area" VALUES ('98', null, null, null, null, '1', null, '222424', '1', null, '汪清县', '20', null, null, null);
INSERT INTO "public"."sys_area" VALUES ('99', null, null, null, null, '1', null, '222426', '1', '128.90089', '安图县', '20', null, null, '43.118108');

-- ----------------------------
-- Table structure for sys_audit
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_audit";
CREATE TABLE "public"."sys_audit" (
"id" int8 NOT NULL,
"createby" varchar(255) COLLATE "default",
"creationdate" timestamp(6),
"updateby" varchar(255) COLLATE "default",
"updatedate" timestamp(6),
"version_" int8,
"action" varchar(255) COLLATE "default",
"actor" varchar(255) COLLATE "default",
"appname" varchar(255) COLLATE "default",
"content" varchar(255) COLLATE "default",
"funname" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of sys_audit
-- ----------------------------
INSERT INTO "public"."sys_audit" VALUES ('24624', null, '2015-12-02 10:56:59.053', null, '2015-12-02 10:56:59.053', '1', '删除', '管理员', '协同办公', 'NewsBean{content=''asas'', title=''asas1'', publishPeople=''管理员'', publishDate=Mon Nov 16 01:11:51 CST 2015}', '公司新闻');
INSERT INTO "public"."sys_audit" VALUES ('24625', null, '2015-12-02 10:57:01.163', null, '2015-12-02 10:57:01.163', '1', '删除', '管理员', '协同办公', 'NewsBean{content=''I''m unfortunately unable to determine what your code is doing and not working.'', title=''asas'', publishPeople=''管理员'', publishDate=Mon Nov 16 01:12:01 CST 2015}', '公司新闻');
INSERT INTO "public"."sys_audit" VALUES ('24626', null, '2015-12-02 10:57:03.381', null, '2015-12-02 10:57:03.381', '1', '删除', '管理员', '协同办公', 'NewsBean{content=''fsfad'', title=''world'', publishPeople=''管理员'', publishDate=Thu Nov 05 00:00:00 CST 2015}', '公司新闻');
INSERT INTO "public"."sys_audit" VALUES ('24627', null, '2015-12-02 10:57:05.475', null, '2015-12-02 10:57:05.475', '1', '删除', '管理员', '协同办公', 'NewsBean{content=''fsdf'', title=''sdsdfd'', publishPeople=''管理员'', publishDate=Thu Jan 01 00:00:00 CST 1970}', '公司新闻');
INSERT INTO "public"."sys_audit" VALUES ('25410', null, '2015-12-02 13:46:13.961', null, '2015-12-02 13:46:13.961', '1', '系统登录', '管理员', '系统应用', '登录地址：0:0:0:0:0:0:0:1', '系统日志');
INSERT INTO "public"."sys_audit" VALUES ('25510', null, '2015-12-02 15:34:29.144', null, '2015-12-02 15:34:29.144', '1', '系统登录', '管理员', '系统应用', '登录地址：0:0:0:0:0:0:0:1', '系统日志');
INSERT INTO "public"."sys_audit" VALUES ('25511', null, '2015-12-02 17:33:13.065', null, '2015-12-02 17:33:13.065', '1', '系统登录', '管理员', '系统应用', '登录地址：0:0:0:0:0:0:0:1', '系统日志');
INSERT INTO "public"."sys_audit" VALUES ('25512', null, '2015-12-02 18:26:43.554', null, '2015-12-02 18:26:43.554', '1', '系统登录', '管理员', '系统应用', '登录地址：0:0:0:0:0:0:0:1', '系统日志');
INSERT INTO "public"."sys_audit" VALUES ('25610', null, '2015-12-02 18:52:48.206', null, '2015-12-02 18:52:48.206', '1', '系统登录', '管理员', '系统应用', '登录地址：0:0:0:0:0:0:0:1', '系统日志');
INSERT INTO "public"."sys_audit" VALUES ('25710', null, '2015-12-02 19:50:02.324', null, '2015-12-02 19:50:02.324', '1', '系统登录', '管理员', '系统应用', '登录地址：0:0:0:0:0:0:0:1', '系统日志');
INSERT INTO "public"."sys_audit" VALUES ('25711', null, '2015-12-02 19:52:52.752', null, '2015-12-02 19:52:52.752', '1', '系统登出', '管理员', '系统应用', '登出地址：0:0:0:0:0:0:0:1', '系统日志');
INSERT INTO "public"."sys_audit" VALUES ('25712', null, '2015-12-02 19:52:57.85', null, '2015-12-02 19:52:57.85', '1', '系统登录', '管理员', '系统应用', '登录地址：0:0:0:0:0:0:0:1', '系统日志');
INSERT INTO "public"."sys_audit" VALUES ('25713', null, '2015-12-02 19:53:09.515', null, '2015-12-02 19:53:09.515', '1', '系统登出', '管理员', '系统应用', '登出地址：0:0:0:0:0:0:0:1', '系统日志');
INSERT INTO "public"."sys_audit" VALUES ('25714', null, '2015-12-02 19:53:14.591', null, '2015-12-02 19:53:14.591', '1', '系统登录', '管理员', '系统应用', '登录地址：0:0:0:0:0:0:0:1', '系统日志');
INSERT INTO "public"."sys_audit" VALUES ('25715', null, '2015-12-02 19:53:51.989', null, '2015-12-02 19:53:51.989', '1', '系统登出', '管理员', '系统应用', '登出地址：0:0:0:0:0:0:0:1', '系统日志');
INSERT INTO "public"."sys_audit" VALUES ('25716', null, '2015-12-02 19:53:57.982', null, '2015-12-02 19:53:57.982', '1', '系统登录', '管理员', '系统应用', '登录地址：0:0:0:0:0:0:0:1', '系统日志');
INSERT INTO "public"."sys_audit" VALUES ('25717', null, '2015-12-02 20:23:28.327', null, '2015-12-02 20:23:28.327', '1', '系统登出', '管理员', '系统应用', '登出地址：0:0:0:0:0:0:0:1', '系统日志');
INSERT INTO "public"."sys_audit" VALUES ('25718', null, '2015-12-02 20:23:34.02', null, '2015-12-02 20:23:34.02', '1', '系统登录', '徐峰', '系统应用', '登录地址：0:0:0:0:0:0:0:1', '系统日志');
INSERT INTO "public"."sys_audit" VALUES ('26310', null, '2015-12-02 20:47:46.074', null, '2015-12-02 20:47:46.074', '1', '系统登录', '管理员', '系统应用', '登录地址：0:0:0:0:0:0:0:1', '系统日志');
INSERT INTO "public"."sys_audit" VALUES ('26410', null, '2015-12-02 21:21:38.166', null, '2015-12-02 21:21:38.166', '1', '系统登录', '管理员', '系统应用', '登录地址：0:0:0:0:0:0:0:1', '系统日志');
INSERT INTO "public"."sys_audit" VALUES ('26510', null, '2015-12-02 22:24:13.249', null, '2015-12-02 22:24:13.249', '1', '系统登录', '管理员', '系统应用', '登录地址：0:0:0:0:0:0:0:1', '系统日志');
INSERT INTO "public"."sys_audit" VALUES ('26610', null, '2015-12-03 09:24:24.548', null, '2015-12-03 09:24:24.548', '1', '系统登录', '管理员', '系统应用', '登录地址：0:0:0:0:0:0:0:1', '系统日志');
INSERT INTO "public"."sys_audit" VALUES ('26611', null, '2015-12-03 09:30:58.892', null, '2015-12-03 09:30:58.892', '1', '系统登录', '管理员', '系统应用', '登录地址：0:0:0:0:0:0:0:1', '系统日志');
INSERT INTO "public"."sys_audit" VALUES ('26710', null, '2015-12-03 14:29:44.388', null, '2015-12-03 14:29:44.388', '1', '系统登录', '管理员', '系统应用', '登录地址：0:0:0:0:0:0:0:1', '系统日志');
INSERT INTO "public"."sys_audit" VALUES ('26711', null, '2015-12-03 14:58:21.839', null, '2015-12-03 14:58:21.839', '1', '系统登录', '管理员', '系统应用', '登录地址：0:0:0:0:0:0:0:1', '系统日志');
INSERT INTO "public"."sys_audit" VALUES ('26712', null, '2015-12-03 15:02:28.787', null, '2015-12-03 15:02:28.787', '1', '系统登出', '管理员', '系统应用', '登出地址：0:0:0:0:0:0:0:1', '系统日志');
INSERT INTO "public"."sys_audit" VALUES ('26713', null, '2015-12-03 15:02:36.22', null, '2015-12-03 15:02:36.22', '1', '系统登录', '徐峰', '系统应用', '登录地址：0:0:0:0:0:0:0:1', '系统日志');

-- ----------------------------
-- Table structure for sys_demo
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_demo";
CREATE TABLE "public"."sys_demo" (
"id" int8 NOT NULL,
"createby" varchar(255) COLLATE "default",
"creationdate" timestamp(6),
"updateby" varchar(255) COLLATE "default",
"updatedate" timestamp(6),
"currentnode" varchar(255) COLLATE "default",
"processinstanceid" varchar(255) COLLATE "default",
"status" int2,
"content" varchar(255) COLLATE "default",
"publishdate" timestamp(6),
"publishpeople" varchar(255) COLLATE "default",
"title" varchar(255) COLLATE "default",
"version_" int8
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of sys_demo
-- ----------------------------
INSERT INTO "public"."sys_demo" VALUES ('501', null, '2015-11-19 20:44:50.113', null, '2015-11-28 21:42:48.268', '符合性审批', '12501', '1', 'as', null, null, 'as', '2');

-- ----------------------------
-- Table structure for sys_department
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_department";
CREATE TABLE "public"."sys_department" (
"id" int8 NOT NULL,
"createby" varchar(255) COLLATE "default",
"creationdate" timestamp(6),
"updateby" varchar(255) COLLATE "default",
"updatedate" timestamp(6),
"version_" int8,
"centercode" varchar(255) COLLATE "default",
"code" varchar(255) COLLATE "default",
"isleaf" int4 NOT NULL,
"name" varchar(255) COLLATE "default",
"orgid" int4 NOT NULL,
"parentid" int8 NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of sys_department
-- ----------------------------
INSERT INTO "public"."sys_department" VALUES ('10', '管理员', '2015-09-24 10:23:47.983', '管理员', '2015-09-24 10:23:47.983', '0', '003', '003', '1', '研发部', '8', '-1');
INSERT INTO "public"."sys_department" VALUES ('48', '管理员', '2015-11-16 15:59:20.203', '管理员', '2015-11-16 15:59:20.203', '0', '001', '001', '1', '平台构建部', '47', '-1');
INSERT INTO "public"."sys_department" VALUES ('49', '管理员', '2015-11-16 15:59:40.692', '管理员', '2015-11-16 15:59:40.692', '0', '002', '002', '1', '质量管理部', '47', '-1');
INSERT INTO "public"."sys_department" VALUES ('50', '管理员', '2015-11-16 16:00:05.248', '管理员', '2015-11-16 16:00:05.248', '0', '003', '003', '1', '项目交付与运维服务部', '47', '-1');
INSERT INTO "public"."sys_department" VALUES ('51', '管理员', '2015-11-16 16:00:25.695', '管理员', '2015-11-16 16:00:25.695', '0', '004', '004', '1', '应用开发部', '47', '-1');
INSERT INTO "public"."sys_department" VALUES ('52', '管理员', '2015-11-16 16:00:40.298', '管理员', '2015-11-16 16:00:40.298', '0', '005', '005', '1', '业务规划部', '47', '-1');
INSERT INTO "public"."sys_department" VALUES ('53', '管理员', '2015-11-16 16:00:53.971', '管理员', '2015-11-16 16:00:53.971', '0', '006', '006', '1', '销售部', '47', '-1');
INSERT INTO "public"."sys_department" VALUES ('54', '管理员', '2015-11-16 16:01:07.498', '管理员', '2015-11-16 16:01:07.498', '0', '007', '007', '1', '商务部', '47', '-1');
INSERT INTO "public"."sys_department" VALUES ('55', '管理员', '2015-11-16 16:01:27.755', '管理员', '2015-11-16 16:01:27.755', '0', '008', '008', '1', '综合部', '47', '-1');
INSERT INTO "public"."sys_department" VALUES ('56', '管理员', '2015-11-16 16:01:42.033', '管理员', '2015-11-16 16:01:42.033', '0', '009', '009', '1', '人事行政部', '47', '-1');
INSERT INTO "public"."sys_department" VALUES ('57', '管理员', '2015-11-16 16:01:58.446', '管理员', '2015-11-16 16:01:58.446', '0', '010', '010', '1', '财务部', '47', '-1');
INSERT INTO "public"."sys_department" VALUES ('4601', 'fdad2222', '2015-07-24 16:58:16', 'fdad2222', '2015-07-24 16:58:16', '1', '010101', '010101', '1', '办事处一部', '4501', '-1');
INSERT INTO "public"."sys_department" VALUES ('6801', '管理员', '2015-07-29 13:29:53', '管理员', '2015-07-31 11:19:39', '12', '020202', '020202', '0', '办事处二部', '4501', '-1');
INSERT INTO "public"."sys_department" VALUES ('10802', '管理员2', '2015-08-03 15:41:37', '管理员2', '2015-08-03 15:41:37', '1', '2', '3', '1', '3', '4501', '6801');
INSERT INTO "public"."sys_department" VALUES ('10803', '管理员2', '2015-08-03 15:41:39', '管理员2', '2015-08-03 15:41:39', '1', '2', '4', '1', '4', '4501', '6801');
INSERT INTO "public"."sys_department" VALUES ('10804', '管理员2', '2015-08-03 15:41:41', '管理员2', '2015-08-03 15:41:41', '1', '2', '5', '1', '5', '4501', '6801');
INSERT INTO "public"."sys_department" VALUES ('10805', '管理员2', '2015-08-03 15:41:43', '管理员2', '2015-08-03 15:41:43', '1', '2', '6', '1', '6', '4501', '6801');
INSERT INTO "public"."sys_department" VALUES ('10806', '管理员2', '2015-08-03 15:41:46', '管理员2', '2015-08-03 15:41:46', '1', '2', '7', '1', '7', '4501', '6801');
INSERT INTO "public"."sys_department" VALUES ('10807', '管理员2', '2015-08-03 15:41:48', '管理员2', '2015-08-03 15:41:48', '1', '2', '8', '1', '8', '4501', '6801');
INSERT INTO "public"."sys_department" VALUES ('10808', '管理员2', '2015-08-03 15:41:50', '管理员2', '2015-08-03 15:41:50', '1', '2', '9', '1', '9', '4501', '6801');
INSERT INTO "public"."sys_department" VALUES ('10809', '管理员2', '2015-08-03 15:41:53', '管理员2', '2015-08-03 15:41:53', '1', '2', '10', '1', '10', '4501', '6801');
INSERT INTO "public"."sys_department" VALUES ('10810', '管理员2', '2015-08-03 15:41:57', '管理员2', '2015-08-03 15:41:57', '1', '2', '11', '1', '11', '4501', '6801');
INSERT INTO "public"."sys_department" VALUES ('10811', '管理员2', '2015-08-03 15:53:47', '管理员2', '2015-08-03 15:53:47', '1', '12', '12', '1', '12', '4501', '6801');
INSERT INTO "public"."sys_department" VALUES ('10812', '管理员2', '2015-08-03 15:53:49', '管理员2', '2015-08-03 15:53:49', '1', '12', '13', '1', '13', '4501', '6801');
INSERT INTO "public"."sys_department" VALUES ('10813', '管理员2', '2015-08-03 15:53:51', '管理员2', '2015-08-03 15:53:51', '1', '12', '14', '1', '14', '4501', '6801');
INSERT INTO "public"."sys_department" VALUES ('10814', '管理员2', '2015-08-03 15:53:54', '管理员2', '2015-08-03 15:53:54', '1', '12', '16', '1', '16', '4501', '6801');
INSERT INTO "public"."sys_department" VALUES ('10815', '管理员2', '2015-08-03 15:53:58', '管理员2', '2015-08-03 15:53:58', '1', '12', '17', '1', '17', '4501', '6801');
INSERT INTO "public"."sys_department" VALUES ('10816', '管理员2', '2015-08-03 15:54:01', '管理员2', '2015-08-03 15:54:01', '1', '12', '18', '1', '18', '4501', '6801');
INSERT INTO "public"."sys_department" VALUES ('10817', '管理员2', '2015-08-03 15:54:03', '管理员2', '2015-08-03 15:54:03', '1', '12', '19', '1', '19', '4501', '6801');
INSERT INTO "public"."sys_department" VALUES ('10818', '管理员2', '2015-08-03 15:54:07', '管理员2', '2015-08-03 15:54:07', '1', '12', '20', '1', '20', '4501', '6801');
INSERT INTO "public"."sys_department" VALUES ('10819', '管理员2', '2015-08-03 15:54:09', '管理员2', '2015-08-03 15:54:09', '1', '12', '21', '1', '21', '4501', '6801');
INSERT INTO "public"."sys_department" VALUES ('10820', '管理员2', '2015-08-03 15:54:12', '管理员2', '2015-08-03 15:54:12', '1', '12', '22', '1', '22', '4501', '6801');
INSERT INTO "public"."sys_department" VALUES ('10821', '管理员2', '2015-08-03 15:54:14', '管理员2', '2015-08-03 15:54:14', '1', '12', '23', '1', '23', '4501', '6801');
INSERT INTO "public"."sys_department" VALUES ('10822', '管理员2', '2015-08-03 15:54:21', '管理员2', '2015-08-03 15:54:21', '1', '24', '24', '1', '24', '4501', '6801');
INSERT INTO "public"."sys_department" VALUES ('10823', '管理员2', '2015-08-03 15:54:24', '管理员2', '2015-08-03 15:54:24', '1', '24', '25', '1', '25', '4501', '6801');
INSERT INTO "public"."sys_department" VALUES ('10824', '管理员2', '2015-08-03 15:54:28', '管理员2', '2015-08-03 15:54:28', '1', '24', '623', '1', '26', '4501', '6801');
INSERT INTO "public"."sys_department" VALUES ('10825', '管理员2', '2015-08-03 15:54:31', '管理员2', '2015-08-03 15:54:31', '1', '24', '27', '1', '27', '4501', '6801');
INSERT INTO "public"."sys_department" VALUES ('10826', '管理员2', '2015-08-03 15:54:34', '管理员2', '2015-08-03 15:54:34', '1', '24', '28', '1', '28', '4501', '6801');
INSERT INTO "public"."sys_department" VALUES ('10827', '管理员2', '2015-08-03 15:54:36', '管理员2', '2015-08-03 15:54:36', '1', '24', '29', '1', '29', '4501', '6801');

-- ----------------------------
-- Table structure for sys_department_user
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_department_user";
CREATE TABLE "public"."sys_department_user" (
"id" int8 NOT NULL,
"createby" varchar(255) COLLATE "default",
"creationdate" timestamp(6),
"updateby" varchar(255) COLLATE "default",
"updatedate" timestamp(6),
"version_" int8,
"depid" int8 NOT NULL,
"userid" int8 NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of sys_department_user
-- ----------------------------
INSERT INTO "public"."sys_department_user" VALUES ('11', '管理员', '2015-09-24 10:25:53.618', '管理员', '2015-09-24 10:25:53.618', '0', '10', '11401');
INSERT INTO "public"."sys_department_user" VALUES ('7810', '管理员', '2015-07-29 17:16:56', '管理员', '2015-07-29 17:16:56', '1', '4601', '5601');
INSERT INTO "public"."sys_department_user" VALUES ('7811', '管理员', '2015-07-29 17:16:56', '管理员', '2015-07-29 17:16:56', '1', '4601', '108');
INSERT INTO "public"."sys_department_user" VALUES ('7812', '管理员', '2015-07-29 17:16:56', '管理员', '2015-07-29 17:16:56', '1', '4601', '109');
INSERT INTO "public"."sys_department_user" VALUES ('9806', '管理员', '2015-07-31 14:42:37', '管理员', '2015-07-31 14:42:37', '1', '6801', '7001');
INSERT INTO "public"."sys_department_user" VALUES ('9807', '管理员', '2015-07-31 14:42:37', '管理员', '2015-07-31 14:42:37', '1', '6801', '8301');

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_dict";
CREATE TABLE "public"."sys_dict" (
"id" int8 NOT NULL,
"createby" varchar(255) COLLATE "default",
"creationdate" timestamp(6),
"updateby" varchar(255) COLLATE "default",
"updatedate" timestamp(6),
"version_" int8,
"description" varchar(255) COLLATE "default",
"label" varchar(255) COLLATE "default",
"sort" int8 NOT NULL,
"type" varchar(255) COLLATE "default",
"value" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
INSERT INTO "public"."sys_dict" VALUES ('1001', null, '2015-07-10 13:21:44', null, '2015-07-10 13:21:44', '3', '性别', '男', '1', 'sex', '1');
INSERT INTO "public"."sys_dict" VALUES ('1101', null, '2015-07-23 15:52:06', 'fdad2222', '2015-07-23 15:52:06', '7', '233333', '女', '2', 'sex', '1');
INSERT INTO "public"."sys_dict" VALUES ('3000', null, null, null, null, '0', null, '草稿', '1', 'contractStatus', '0');
INSERT INTO "public"."sys_dict" VALUES ('3001', null, null, null, null, '0', null, '进行中', '2', 'contractStatus', '1');
INSERT INTO "public"."sys_dict" VALUES ('3002', '', null, null, null, '0', null, '完成', '3', 'contractStatus', '2');

-- ----------------------------
-- Table structure for sys_function
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_function";
CREATE TABLE "public"."sys_function" (
"id" int8 NOT NULL,
"createby" varchar(255) COLLATE "default",
"creationdate" timestamp(6),
"updateby" varchar(255) COLLATE "default",
"updatedate" timestamp(6),
"version_" int8,
"applicationid" int4 NOT NULL,
"code" varchar(255) COLLATE "default",
"isleaf" int4 NOT NULL,
"name" varchar(255) COLLATE "default",
"parentid" int8 NOT NULL,
"permission" varchar(255) COLLATE "default",
"remark" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of sys_function
-- ----------------------------
INSERT INTO "public"."sys_function" VALUES ('59', '管理员', '2015-11-16 16:15:41.364', '管理员', '2015-12-02 09:37:04.774', '2', '58', 'cmModule', '0', '销售管理', '-1', 'roffice:cmModule', '');
INSERT INTO "public"."sys_function" VALUES ('60', '管理员', '2015-11-16 16:16:31.564', '管理员', '2015-12-02 09:37:04.613', '2', '58', 'contractMenu', '0', '项目合同', '59', 'roffice:cmModule:contractMenu', '');
INSERT INTO "public"."sys_function" VALUES ('61', '管理员', '2015-11-16 16:17:09.76', '管理员', '2015-12-02 09:37:04.684', '2', '58', 'invoiceMenu', '0', '合同发票', '59', 'roffice:cmModule:invoiceMenu', '');
INSERT INTO "public"."sys_function" VALUES ('62', '管理员', '2015-11-16 16:17:29.394', '管理员', '2015-12-02 09:37:04.713', '2', '58', 'contractDetailMenu', '0', '合同清单', '59', 'roffice:cmModule:contractDetailMenu', '');
INSERT INTO "public"."sys_function" VALUES ('207', 'qwer', '2015-11-16 21:55:09.021', 'qwer', '2015-11-16 22:07:05.191', '1', '7901', 'sysModule', '0', '系统管理', '-1', 'admin:sysModule', '');
INSERT INTO "public"."sys_function" VALUES ('208', 'qwer', '2015-11-16 21:55:42.383', 'qwer', '2015-11-16 22:05:17.276', '1', '7901', 'constructModule', '0', '组织结构', '-1', 'admin:constructModule', '');
INSERT INTO "public"."sys_function" VALUES ('209', 'qwer', '2015-11-16 21:56:17.097', 'qwer', '2015-11-16 22:03:07.612', '1', '7901', 'permissionModule', '0', '权限管理', '-1', 'admin:permissionModule', '');
INSERT INTO "public"."sys_function" VALUES ('210', '管理员', '2015-11-16 22:03:07.596', '管理员', '2015-11-16 22:19:37.39', '1', '7901', 'userMenu', '0', '用户管理', '209', 'admin:permissionModule:userMenu', '');
INSERT INTO "public"."sys_function" VALUES ('211', '管理员', '2015-11-16 22:03:27.573', '管理员', '2015-11-16 22:03:27.573', '0', '7901', 'roleMenu', '1', '角色管理', '209', 'admin:permissionModule:roleMenu', '');
INSERT INTO "public"."sys_function" VALUES ('212', '管理员', '2015-11-16 22:03:48.698', '管理员', '2015-11-16 22:03:48.698', '0', '7901', 'workGroupMenu', '1', '工作组管理', '209', 'admin:permissionModule:workGroupMenu', '');
INSERT INTO "public"."sys_function" VALUES ('213', 'qwer', '2015-11-16 22:05:17.263', '管理员', '2015-11-17 01:12:30.635', '2', '7901', 'areaMenu', '1', '区域管理', '208', 'admin:constructModule:areaMenu', '');
INSERT INTO "public"."sys_function" VALUES ('214', 'qwer', '2015-11-16 22:05:34.047', 'qwer', '2015-11-16 22:05:34.047', '0', '7901', 'organizationMenu', '1', '机构管理', '208', 'admin:constructModule:organizationMenu', '');
INSERT INTO "public"."sys_function" VALUES ('215', 'qwer', '2015-11-16 22:05:49.971', 'qwer', '2015-11-16 22:05:49.971', '0', '7901', 'departmentMenu', '1', '部门管理', '208', 'admin:constructModule:departmentMenu', '');
INSERT INTO "public"."sys_function" VALUES ('216', 'qwer', '2015-11-16 22:07:05.172', 'qwer', '2015-11-16 22:07:05.172', '0', '7901', 'dictMenu', '1', '字典管理', '207', 'admin:sysModule:dictMenu', '');
INSERT INTO "public"."sys_function" VALUES ('217', 'qwer', '2015-11-16 22:07:30.504', 'qwer', '2015-11-16 22:07:30.504', '0', '7901', 'auditMenu', '1', '审计管理', '207', 'admin:sysModule:auditMenu', '');
INSERT INTO "public"."sys_function" VALUES ('250', 'qwer', '2015-11-16 22:09:51.329', 'qwer', '2015-11-16 22:10:12.735', '1', '7901', 'appModule', '0', '模块管理', '-1', 'admin:appModule', '');
INSERT INTO "public"."sys_function" VALUES ('251', 'qwer', '2015-11-16 22:10:12.722', 'qwer', '2015-11-16 22:10:12.722', '0', '7901', 'applicationMenu', '1', '应用管理', '250', 'admin:appModule:applicationMenu', '');
INSERT INTO "public"."sys_function" VALUES ('252', 'qwer', '2015-11-16 22:10:37.541', 'qwer', '2015-11-16 22:10:37.541', '0', '7901', 'functionMenu', '1', '功能管理', '250', 'admin:appModule:functionMenu', '');
INSERT INTO "public"."sys_function" VALUES ('275', '管理员', '2015-11-16 22:17:40.313', '管理员', '2015-11-17 00:56:22.128', '4', '12501', 'noticeMenu', '1', '流程演示管理', '13713', 'workflow:workFlowModule:noticeMenu', '');
INSERT INTO "public"."sys_function" VALUES ('276', '管理员', '2015-11-16 22:17:58.518', '管理员', '2015-11-17 00:56:20.275', '4', '12501', 'processDefinitionMenu', '1', '流程定义管理', '13713', 'workflow:workFlowModule:processDefinitionMenu', '');
INSERT INTO "public"."sys_function" VALUES ('277', '管理员', '2015-11-16 22:18:15.666', '管理员', '2015-11-17 00:56:21.173', '4', '12501', 'processHistoryMenu', '1', '流程历史列表', '13713', 'workflow:workFlowModule:processHistoryMenu', '');
INSERT INTO "public"."sys_function" VALUES ('278', '管理员', '2015-11-16 22:18:29.509', '管理员', '2015-11-17 00:56:21.655', '4', '12501', 'taskMenu', '1', '待办任务列表', '13713', 'workflow:workFlowModule:taskMenu', '');
INSERT INTO "public"."sys_function" VALUES ('279', '管理员', '2015-11-16 22:19:37.378', '管理员', '2015-11-16 22:19:37.378', '0', '7901', 'add', '1', '添加', '210', 'admin:permissionModule:userMenu:add', '添加按钮');
INSERT INTO "public"."sys_function" VALUES ('280', '管理员', '2015-11-16 22:19:53.522', '管理员', '2015-11-16 22:19:53.522', '0', '7901', 'delete', '1', '删除', '210', 'admin:permissionModule:userMenu:delete', '删除按钮');
INSERT INTO "public"."sys_function" VALUES ('281', '管理员', '2015-11-16 22:20:12.907', '管理员', '2015-11-16 23:01:14.104', '1', '7901', 'edit', '1', '编辑', '210', 'admin:permissionModule:userMenu:edit', '编辑按钮');
INSERT INTO "public"."sys_function" VALUES ('282', '管理员', '2015-11-16 22:20:30.729', '管理员', '2015-11-16 22:20:30.729', '0', '7901', 'view', '1', '查看', '210', 'admin:permissionModule:userMenu:view', '查看按钮');
INSERT INTO "public"."sys_function" VALUES ('339', '管理员', '2015-11-16 22:46:58.021', '管理员', '2015-11-16 22:50:30.349', '1', '58', 'commonsModule', '0', '通用功能', '-1', 'roffice:commonsModule', '');
INSERT INTO "public"."sys_function" VALUES ('340', '管理员', '2015-11-16 22:47:22.318', '管理员', '2015-11-16 22:51:19.485', '1', '58', 'saleModule', '0', '售前服务', '-1', 'roffice:saleModule', '');
INSERT INTO "public"."sys_function" VALUES ('341', '管理员', '2015-11-16 22:48:28.152', '管理员', '2015-11-16 22:53:37.138', '1', '58', 'deployModule', '0', '项目交付', '-1', 'roffice:deployModule', '');
INSERT INTO "public"."sys_function" VALUES ('342', '管理员', '2015-11-16 22:50:30.335', '管理员', '2015-11-16 23:02:38.043', '1', '58', 'newsMenu', '0', '公司新闻', '339', 'roffice:commonsModule:newsMenu', '');
INSERT INTO "public"."sys_function" VALUES ('343', '管理员', '2015-11-16 22:50:47.011', '管理员', '2015-11-16 23:03:18.101', '1', '58', 'noteMenu', '0', '公司公告', '339', 'roffice:commonsModule:noteMenu', '');
INSERT INTO "public"."sys_function" VALUES ('344', '管理员', '2015-11-16 22:51:19.47', '管理员', '2015-11-16 23:14:01.174', '1', '58', 'travelMenu', '0', '出差记录', '340', 'roffice:saleModule:travelMenu', '');
INSERT INTO "public"."sys_function" VALUES ('345', '管理员', '2015-11-16 22:51:32.33', '管理员', '2015-11-16 23:10:24.884', '1', '58', 'supportMenu', '0', '项目支持', '340', 'roffice:saleModule:supportMenu', '');
INSERT INTO "public"."sys_function" VALUES ('346', '管理员', '2015-11-16 22:51:45.391', '管理员', '2015-11-16 23:11:11.654', '1', '58', 'chanceMenu', '0', '项目机会', '59', 'roffice:cmModule:chanceMenu', '');
INSERT INTO "public"."sys_function" VALUES ('347', '管理员', '2015-11-16 22:52:27.79', '管理员', '2015-11-16 23:14:48.135', '1', '58', 'projectMenu', '0', '项目管理', '340', 'roffice:saleModule:projectMenu', '');
INSERT INTO "public"."sys_function" VALUES ('348', '管理员', '2015-11-16 22:53:37.125', '管理员', '2015-11-16 23:15:36.254', '1', '58', 'receiveMenu', '0', '项目回款', '59', 'roffice:cmModule:receiveMenu', '');
INSERT INTO "public"."sys_function" VALUES ('349', '管理员', '2015-11-16 22:54:03.281', '管理员', '2015-11-16 23:16:19.292', '1', '58', 'deployMenu', '0', '实施项目', '341', 'roffice:deployModule:deployMenu', '');
INSERT INTO "public"."sys_function" VALUES ('350', '管理员', '2015-11-16 22:54:27.832', '管理员', '2015-11-16 23:16:54.668', '1', '58', 'payMenu', '0', '采购付款', '59', 'roffice:cmModule:payMenu', '');
INSERT INTO "public"."sys_function" VALUES ('351', '管理员', '2015-11-16 22:54:52.582', '管理员', '2015-11-16 23:17:36.474', '1', '58', 'purchaseInvoiceMenu', '0', '设备发票', '59', 'roffice:cmModule:purchaseInvoiceMenu', '');
INSERT INTO "public"."sys_function" VALUES ('352', '管理员', '2015-11-16 22:57:42.971', '管理员', '2015-12-02 09:37:04.662', '1', '58', 'add', '1', '添加', '60', 'roffice:cmModule:contractMenu:add', '');
INSERT INTO "public"."sys_function" VALUES ('353', '管理员', '2015-11-16 22:57:55.784', '管理员', '2015-12-02 09:37:04.667', '1', '58', 'delete', '1', '删除', '60', 'roffice:cmModule:contractMenu:delete', '');
INSERT INTO "public"."sys_function" VALUES ('354', '管理员', '2015-11-16 22:58:06.556', '管理员', '2015-12-02 09:37:04.68', '2', '58', 'edit', '1', '编辑', '60', 'roffice:cmModule:contractMenu:edit', '');
INSERT INTO "public"."sys_function" VALUES ('355', '管理员', '2015-11-16 22:58:15.813', '管理员', '2015-12-02 09:37:04.675', '1', '58', 'view', '1', '查看', '60', 'roffice:cmModule:contractMenu:view', '');
INSERT INTO "public"."sys_function" VALUES ('356', '管理员', '2015-11-16 22:59:05.814', '管理员', '2015-12-02 09:37:04.694', '1', '58', 'add', '1', '添加', '61', 'roffice:cmModule:invoiceMenu:add', '');
INSERT INTO "public"."sys_function" VALUES ('357', '管理员', '2015-11-16 22:59:15.676', '管理员', '2015-12-02 09:37:04.7', '1', '58', 'delete', '1', '删除', '61', 'roffice:cmModule:invoiceMenu:delete', '');
INSERT INTO "public"."sys_function" VALUES ('358', '管理员', '2015-11-16 23:00:43.388', '管理员', '2015-12-02 09:37:04.705', '1', '58', 'edit', '1', '编辑', '61', 'roffice:cmModule:invoiceMenu:edit', '');
INSERT INTO "public"."sys_function" VALUES ('359', '管理员', '2015-11-16 23:00:57.85', '管理员', '2015-12-02 09:37:04.709', '1', '58', 'view', '1', '查看', '61', 'roffice:cmModule:invoiceMenu:view', '');
INSERT INTO "public"."sys_function" VALUES ('360', '管理员', '2015-11-16 23:01:38.901', '管理员', '2015-12-02 09:37:04.722', '1', '58', 'add', '1', '添加', '62', 'roffice:cmModule:contractDetailMenu:add', '');
INSERT INTO "public"."sys_function" VALUES ('361', '管理员', '2015-11-16 23:01:54.397', '管理员', '2015-12-02 09:37:04.726', '1', '58', 'delete', '1', '删除', '62', 'roffice:cmModule:contractDetailMenu:delete', '');
INSERT INTO "public"."sys_function" VALUES ('362', '管理员', '2015-11-16 23:02:08.026', '管理员', '2015-12-02 09:37:04.732', '1', '58', 'edit', '1', '编辑', '62', 'roffice:cmModule:contractDetailMenu:edit', '');
INSERT INTO "public"."sys_function" VALUES ('363', '管理员', '2015-11-16 23:02:16.935', '管理员', '2015-12-02 09:37:04.739', '1', '58', 'view', '1', '查看', '62', 'roffice:cmModule:contractDetailMenu:view', '');
INSERT INTO "public"."sys_function" VALUES ('364', '管理员', '2015-11-16 23:02:38.03', '管理员', '2015-11-16 23:02:38.03', '0', '58', 'add', '1', '添加', '342', 'roffice:commonsModule:newsMenu:add', '');
INSERT INTO "public"."sys_function" VALUES ('365', '管理员', '2015-11-16 23:02:48.739', '管理员', '2015-11-16 23:02:48.739', '0', '58', 'delete', '1', '删除', '342', 'roffice:commonsModule:newsMenu:delete', '');
INSERT INTO "public"."sys_function" VALUES ('366', '管理员', '2015-11-16 23:02:56.941', '管理员', '2015-11-16 23:02:56.941', '0', '58', 'edit', '1', '编辑', '342', 'roffice:commonsModule:newsMenu:edit', '');
INSERT INTO "public"."sys_function" VALUES ('367', '管理员', '2015-11-16 23:03:03.728', '管理员', '2015-11-16 23:03:03.728', '0', '58', 'view', '1', '查看', '342', 'roffice:commonsModule:newsMenu:view', '');
INSERT INTO "public"."sys_function" VALUES ('368', '管理员', '2015-11-16 23:03:18.088', '管理员', '2015-11-16 23:03:18.088', '0', '58', 'add', '1', '添加', '343', 'roffice:commonsModule:noteMenu:add', '');
INSERT INTO "public"."sys_function" VALUES ('369', '管理员', '2015-11-16 23:03:26.517', '管理员', '2015-11-16 23:03:26.517', '0', '58', 'delete', '1', '删除', '343', 'roffice:commonsModule:noteMenu:delete', '');
INSERT INTO "public"."sys_function" VALUES ('370', '管理员', '2015-11-16 23:03:33.874', '管理员', '2015-11-16 23:03:33.874', '0', '58', 'edit', '1', '编辑', '343', 'roffice:commonsModule:noteMenu:edit', '');
INSERT INTO "public"."sys_function" VALUES ('371', '管理员', '2015-11-16 23:03:40.774', '管理员', '2015-11-16 23:03:40.774', '0', '58', 'view', '1', '查看', '343', 'roffice:commonsModule:noteMenu:view', '');
INSERT INTO "public"."sys_function" VALUES ('372', '管理员', '2015-11-16 23:10:24.872', '管理员', '2015-11-16 23:10:24.872', '0', '58', 'add', '1', '添加', '345', 'roffice:saleModule:supportMenu:add', '');
INSERT INTO "public"."sys_function" VALUES ('373', '管理员', '2015-11-16 23:10:39.964', '管理员', '2015-11-16 23:10:39.964', '0', '58', 'delete', '1', '删除', '345', 'roffice:saleModule:supportMenu:delete', '');
INSERT INTO "public"."sys_function" VALUES ('374', '管理员', '2015-11-16 23:10:47.534', '管理员', '2015-11-16 23:10:47.534', '0', '58', 'edit', '1', '编辑', '345', 'roffice:saleModule:supportMenu:edit', '');
INSERT INTO "public"."sys_function" VALUES ('375', '管理员', '2015-11-16 23:10:55.042', '管理员', '2015-11-16 23:10:55.042', '0', '58', 'view', '1', '查看', '345', 'roffice:saleModule:supportMenu:view', '');
INSERT INTO "public"."sys_function" VALUES ('376', '管理员', '2015-11-16 23:11:11.641', '管理员', '2015-11-16 23:11:11.641', '0', '58', 'add', '1', '添加', '346', 'roffice:saleModule:chanceMenu:add', '');
INSERT INTO "public"."sys_function" VALUES ('377', '管理员', '2015-11-16 23:11:28.595', '管理员', '2015-11-16 23:11:28.595', '0', '58', 'delete', '1', '删除', '346', 'roffice:saleModule:chanceMenu:delete', '');
INSERT INTO "public"."sys_function" VALUES ('378', '管理员', '2015-11-16 23:11:35.045', '管理员', '2015-11-16 23:11:35.045', '0', '58', 'edit', '1', '编辑', '346', 'roffice:saleModule:chanceMenu:edit', '');
INSERT INTO "public"."sys_function" VALUES ('379', '管理员', '2015-11-16 23:11:41.267', '管理员', '2015-11-16 23:11:41.267', '0', '58', 'view', '1', '查看', '346', 'roffice:saleModule:chanceMenu:view', '');
INSERT INTO "public"."sys_function" VALUES ('380', '管理员', '2015-11-16 23:14:01.16', '管理员', '2015-11-16 23:14:01.16', '0', '58', 'add', '1', '添加', '344', 'roffice:saleModule:travelMenu:add', '');
INSERT INTO "public"."sys_function" VALUES ('381', '管理员', '2015-11-16 23:14:15.377', '管理员', '2015-11-16 23:14:15.377', '0', '58', 'delete', '1', '删除', '344', 'roffice:saleModule:travelMenu:delete', '');
INSERT INTO "public"."sys_function" VALUES ('382', '管理员', '2015-11-16 23:14:22.949', '管理员', '2015-11-16 23:14:22.949', '0', '58', 'edit', '1', '编辑', '344', 'roffice:saleModule:travelMenu:edit', '');
INSERT INTO "public"."sys_function" VALUES ('383', '管理员', '2015-11-16 23:14:31.525', '管理员', '2015-11-16 23:14:31.525', '0', '58', 'view', '1', '查看', '344', 'roffice:saleModule:travelMenu:view', '');
INSERT INTO "public"."sys_function" VALUES ('384', '管理员', '2015-11-16 23:14:48.122', '管理员', '2015-11-16 23:14:48.122', '0', '58', 'add', '1', '添加', '347', 'roffice:saleModule:projectMenu:add', '');
INSERT INTO "public"."sys_function" VALUES ('385', '管理员', '2015-11-16 23:15:00.03', '管理员', '2015-11-16 23:15:00.03', '0', '58', 'delete', '1', '删除', '347', 'roffice:saleModule:projectMenu:delete', '');
INSERT INTO "public"."sys_function" VALUES ('386', '管理员', '2015-11-16 23:15:07.841', '管理员', '2015-11-16 23:15:07.841', '0', '58', 'edit', '1', '编辑', '347', 'roffice:saleModule:projectMenu:edit', '');
INSERT INTO "public"."sys_function" VALUES ('387', '管理员', '2015-11-16 23:15:16.382', '管理员', '2015-11-16 23:15:16.382', '0', '58', 'view', '1', '查看', '347', 'roffice:saleModule:projectMenu:view', '');
INSERT INTO "public"."sys_function" VALUES ('388', '管理员', '2015-11-16 23:15:36.242', '管理员', '2015-11-16 23:15:36.242', '0', '58', 'add', '1', '添加', '348', 'roffice:deployModule:receiveMenu:add', '');
INSERT INTO "public"."sys_function" VALUES ('389', '管理员', '2015-11-16 23:15:44.374', '管理员', '2015-11-16 23:15:44.374', '0', '58', 'delete', '1', '删除', '348', 'roffice:deployModule:receiveMenu:delete', '');
INSERT INTO "public"."sys_function" VALUES ('390', '管理员', '2015-11-16 23:15:51.77', '管理员', '2015-11-16 23:15:51.77', '0', '58', 'edit', '1', '编辑', '348', 'roffice:deployModule:receiveMenu:edit', '');
INSERT INTO "public"."sys_function" VALUES ('391', '管理员', '2015-11-16 23:15:58.976', '管理员', '2015-11-16 23:15:58.976', '0', '58', 'view', '1', '查看', '348', 'roffice:deployModule:receiveMenu:view', '');
INSERT INTO "public"."sys_function" VALUES ('392', '管理员', '2015-11-16 23:16:19.279', '管理员', '2015-11-16 23:16:19.279', '0', '58', 'add', '1', '添加', '349', 'roffice:deployModule:deployMenu:add', '');
INSERT INTO "public"."sys_function" VALUES ('393', '管理员', '2015-11-16 23:16:26.768', '管理员', '2015-11-16 23:16:26.768', '0', '58', 'delete', '1', '删除', '349', 'roffice:deployModule:deployMenu:delete', '');
INSERT INTO "public"."sys_function" VALUES ('394', '管理员', '2015-11-16 23:16:34.753', '管理员', '2015-11-16 23:16:34.753', '0', '58', 'edit', '1', '编辑', '349', 'roffice:deployModule:deployMenu:edit', '');
INSERT INTO "public"."sys_function" VALUES ('395', '管理员', '2015-11-16 23:16:42.834', '管理员', '2015-11-16 23:16:42.834', '0', '58', 'view', '1', '查看', '349', 'roffice:deployModule:deployMenu:view', '');
INSERT INTO "public"."sys_function" VALUES ('396', '管理员', '2015-11-16 23:16:54.656', '管理员', '2015-11-16 23:16:54.656', '0', '58', 'add', '1', '添加', '350', 'roffice:deployModule:payMenu:add', '');
INSERT INTO "public"."sys_function" VALUES ('397', '管理员', '2015-11-16 23:17:05.751', '管理员', '2015-11-16 23:17:05.751', '0', '58', 'delete', '1', '删除', '350', 'roffice:deployModule:payMenu:delete', '');
INSERT INTO "public"."sys_function" VALUES ('398', '管理员', '2015-11-16 23:17:12.62', '管理员', '2015-11-16 23:17:12.62', '0', '58', 'edit', '1', '编辑', '350', 'roffice:deployModule:payMenu:edit', '');
INSERT INTO "public"."sys_function" VALUES ('399', '管理员', '2015-11-16 23:17:22.981', '管理员', '2015-11-16 23:17:22.981', '0', '58', 'view', '1', '查看', '350', 'roffice:deployModule:payMenu:view', '');
INSERT INTO "public"."sys_function" VALUES ('400', '管理员', '2015-11-16 23:17:36.46', '管理员', '2015-11-16 23:17:36.46', '0', '58', 'add', '1', '添加', '351', 'roffice:deployModule:purchaseInvoiceMenu:add', '');
INSERT INTO "public"."sys_function" VALUES ('401', '管理员', '2015-11-16 23:17:43.831', '管理员', '2015-11-16 23:17:43.831', '0', '58', 'delete', '1', '删除', '351', 'roffice:deployModule:purchaseInvoiceMenu:delete', '');
INSERT INTO "public"."sys_function" VALUES ('402', '管理员', '2015-11-16 23:17:51.504', '管理员', '2015-11-16 23:17:51.504', '0', '58', 'edit', '1', '编辑', '351', 'roffice:deployModule:purchaseInvoiceMenu:edit', '');
INSERT INTO "public"."sys_function" VALUES ('403', '管理员', '2015-11-16 23:17:58.222', '管理员', '2015-11-16 23:17:58.222', '0', '58', 'view', '1', '查看', '351', 'roffice:deployModule:purchaseInvoiceMenu:view', '');
INSERT INTO "public"."sys_function" VALUES ('13713', '管理员2', '2015-08-13 10:37:43', '管理员', '2015-11-17 00:56:22.586', '11', '12501', 'workFlowModule', '0', '工作流演示', '-1', 'workflow:workFlowModule', '工作流演示模块');
INSERT INTO "public"."sys_function" VALUES ('22810', '管理员', '2015-11-27 21:04:39.326', '管理员', '2015-12-02 09:37:04.746', '3', '58', 'taskMenu', '0', '任务目标', '59', 'roffice:cmModule:taskMenu', '');
INSERT INTO "public"."sys_function" VALUES ('22811', '管理员', '2015-11-27 21:05:03.693', '管理员', '2015-12-02 09:37:04.756', '2', '58', 'add', '1', '添加', '22810', 'roffice:cmModule:taskMenu:add', '');
INSERT INTO "public"."sys_function" VALUES ('22812', '管理员', '2015-11-27 21:05:25.198', '管理员', '2015-12-02 09:37:04.762', '2', '58', 'delete', '1', '删除', '22810', 'roffice:cmModule:taskMenu:delete', '');
INSERT INTO "public"."sys_function" VALUES ('22813', '管理员', '2015-11-27 21:05:35.009', '管理员', '2015-12-02 09:37:04.77', '3', '58', 'edit', '1', '编辑', '22810', 'roffice:cmModule:taskMenu:edit', '');
INSERT INTO "public"."sys_function" VALUES ('22814', '管理员', '2015-11-27 21:05:46.814', '管理员', '2015-12-02 09:37:04.766', '2', '58', 'view', '1', '查看', '22810', 'roffice:cmModule:taskMenu:view', '');
INSERT INTO "public"."sys_function" VALUES ('24710', '管理员', '2015-12-02 10:37:00.19', '管理员', '2015-12-02 10:40:02.237', '2', '58', 'reportModule', '0', '统计报表', '-1', 'roffice:reportModule', '');
INSERT INTO "public"."sys_function" VALUES ('24711', '管理员', '2015-12-02 10:40:02.219', '管理员', '2015-12-02 10:40:02.219', '1', '58', 'contactReportMenu', '1', '合同报表', '24710', 'roffice:reportModule:contactReportMenu', '');
INSERT INTO "public"."sys_function" VALUES ('25810', '管理员', '2015-12-02 19:50:46.328', '管理员', '2015-12-02 19:50:46.328', '1', '58', 'receiveReportMenu', '1', '合同回款情况', '24710', 'roffice:reportModule:receiveReportMenu', '');

-- ----------------------------
-- Table structure for sys_hello
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_hello";
CREATE TABLE "public"."sys_hello" (
"id" int8 NOT NULL,
"createby" varchar(255) COLLATE "default",
"creationdate" timestamp(6),
"updateby" varchar(255) COLLATE "default",
"updatedate" timestamp(6),
"version_" int8,
"content" varchar(255) COLLATE "default" NOT NULL,
"publishdate" timestamp(6),
"publishpeople" varchar(255) COLLATE "default",
"title" varchar(255) COLLATE "default" NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of sys_hello
-- ----------------------------
INSERT INTO "public"."sys_hello" VALUES ('93', null, '2015-09-28 20:29:31.337', null, '2015-09-28 20:29:31.337', '0', 'd', null, null, 'sd');

-- ----------------------------
-- Table structure for sys_message
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_message";
CREATE TABLE "public"."sys_message" (
"id" int8 NOT NULL,
"createby" varchar(255) COLLATE "default",
"creationdate" timestamp(6),
"updateby" varchar(255) COLLATE "default",
"updatedate" timestamp(6),
"version_" int8,
"message" varchar(255) COLLATE "default",
"sender" varchar(255) COLLATE "default",
"status" int4 NOT NULL,
"title" varchar(255) COLLATE "default",
"userid" int8 NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of sys_message
-- ----------------------------

-- ----------------------------
-- Table structure for sys_news
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_news";
CREATE TABLE "public"."sys_news" (
"id" int8 NOT NULL,
"createby" varchar(255) COLLATE "default",
"creationdate" timestamp(6),
"updateby" varchar(255) COLLATE "default",
"updatedate" timestamp(6),
"version_" int8,
"content" varchar(255) COLLATE "default",
"publishdate" timestamp(6),
"publishpeople" varchar(255) COLLATE "default",
"title" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of sys_news
-- ----------------------------
INSERT INTO "public"."sys_news" VALUES ('225', null, '2015-11-03 00:45:09.271', null, '2015-11-03 00:45:09.277', '2', 'wewe123', '2015-11-03 00:45:09.277', '管理员', 'wom12');
INSERT INTO "public"."sys_news" VALUES ('226', null, '2015-11-02 23:11:23.788', null, '2015-11-02 23:11:23.79', '1', 'wewe1235', '2015-11-02 23:11:23.79', '管理员', 'wom1234');
INSERT INTO "public"."sys_news" VALUES ('228', null, '2015-11-03 00:57:22.092', null, '2015-11-03 00:57:22.092', '0', 'sdsd', '2015-11-03 00:57:22.093', '管理员', 'asd');
INSERT INTO "public"."sys_news" VALUES ('229', null, '2015-11-03 00:57:32.113', null, '2015-11-03 00:57:32.113', '0', 'sdsd', '2015-11-03 00:57:32.114', '管理员', 'asd');
INSERT INTO "public"."sys_news" VALUES ('230', null, '2015-11-03 00:57:49.033', null, '2015-11-03 00:57:49.033', '0', 'sdsd', '2015-11-03 00:57:49.035', '管理员', 'asd');
INSERT INTO "public"."sys_news" VALUES ('231', null, '2015-11-03 01:03:09.113', null, '2015-11-03 01:03:09.116', '1', 'sdsd123', '2015-11-03 01:03:09.115', '管理员', 'asd');
INSERT INTO "public"."sys_news" VALUES ('233', null, '2015-11-03 01:06:15.161', null, '2015-11-03 01:06:15.161', '0', '到山顶', '2015-11-03 01:06:15.162', '管理员', '撒的撒');
INSERT INTO "public"."sys_news" VALUES ('234', null, '2015-11-03 01:11:55.305', null, '2015-11-03 01:11:55.305', '0', '说的', '2015-11-03 01:11:55.307', '管理员', '的所得税');
INSERT INTO "public"."sys_news" VALUES ('235', null, '2015-11-03 01:12:07.158', null, '2015-11-03 01:12:07.158', '0', 'dsd', '2015-11-03 01:12:07.16', '管理员', 'sdsd');
INSERT INTO "public"."sys_news" VALUES ('236', null, '2015-11-03 01:12:19.936', null, '2015-11-03 01:12:19.936', '0', 'sdsd', '2015-11-03 01:12:19.937', '管理员', 'sdsdsd');
INSERT INTO "public"."sys_news" VALUES ('237', null, '2015-11-03 01:12:41.633', null, '2015-11-03 01:12:41.633', '0', 'sdsd', '2015-11-03 01:12:41.634', '管理员', 'sdsd');
INSERT INTO "public"."sys_news" VALUES ('238', null, '2015-11-03 01:13:07.49', null, '2015-11-03 01:13:07.49', '0', 'wewe', '2015-11-03 01:13:07.491', '管理员', 'wewewe');
INSERT INTO "public"."sys_news" VALUES ('239', null, '2015-11-03 01:13:57.002', null, '2015-11-03 01:13:57.002', '0', 'wewe', '2015-11-03 01:13:57.003', '管理员', 'wewewe');
INSERT INTO "public"."sys_news" VALUES ('240', null, '2015-11-03 01:14:34.486', null, '2015-11-03 01:14:34.486', '0', 'dsd', '2015-11-03 01:14:34.489', '管理员', 'sdsds');
INSERT INTO "public"."sys_news" VALUES ('241', null, '2015-11-03 01:16:55.711', null, '2015-11-03 01:16:55.711', '0', 'sdsd', '2015-11-03 01:16:55.715', '管理员', 'sds');
INSERT INTO "public"."sys_news" VALUES ('244', null, '2015-11-03 17:45:33.051', null, '2015-11-03 17:45:33.052', '3', 'we1212', '2015-11-03 01:21:55.507', 'qwer', 'we1234');
INSERT INTO "public"."sys_news" VALUES ('245', null, '2015-11-03 17:45:17.788', null, '2015-11-03 17:45:17.789', '1', '发的说法1213', '2015-11-03 10:57:06.242', '管理员', 'sdfdsf3132');
INSERT INTO "public"."sys_news" VALUES ('246', null, '2015-11-03 17:44:22.139', null, '2015-11-03 17:44:22.14', '1', 'q122', '2015-11-03 11:19:18.448', '管理员', 'qwer12');

-- ----------------------------
-- Table structure for sys_office
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_office";
CREATE TABLE "public"."sys_office" (
"id" int8 NOT NULL,
"createby" varchar(255) COLLATE "default",
"creationdate" timestamp(6),
"updateby" varchar(255) COLLATE "default",
"updatedate" timestamp(6),
"version_" int8,
"address" varchar(255) COLLATE "default",
"areabean" bytea,
"code" varchar(255) COLLATE "default",
"email" varchar(255) COLLATE "default",
"fax" varchar(255) COLLATE "default",
"grade" varchar(255) COLLATE "default",
"master" varchar(255) COLLATE "default",
"name" varchar(255) COLLATE "default",
"parentids" varchar(255) COLLATE "default",
"phone" varchar(255) COLLATE "default",
"type" varchar(255) COLLATE "default",
"zipcode" varchar(255) COLLATE "default",
"parent_id" int8,
"area_id" bytea
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of sys_office
-- ----------------------------

-- ----------------------------
-- Table structure for sys_organization
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_organization";
CREATE TABLE "public"."sys_organization" (
"id" int8 NOT NULL,
"createby" varchar(255) COLLATE "default",
"creationdate" timestamp(6),
"updateby" varchar(255) COLLATE "default",
"updatedate" timestamp(6),
"version_" int8,
"areaid" int4 NOT NULL,
"centercode" varchar(255) COLLATE "default",
"code" varchar(255) COLLATE "default",
"isleaf" int4 NOT NULL,
"name" varchar(255) COLLATE "default",
"parentid" int8 NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of sys_organization
-- ----------------------------
INSERT INTO "public"."sys_organization" VALUES ('8', '管理员', '2015-09-24 09:57:21.991', '管理员', '2015-09-24 09:57:21.991', '0', '2', '001', '001', '1', '工商局', '-1');
INSERT INTO "public"."sys_organization" VALUES ('9', '管理员', '2015-09-24 09:59:18.711', '管理员', '2015-09-24 09:59:18.711', '0', '2', '000', '000', '1', '测试机构', '-1');
INSERT INTO "public"."sys_organization" VALUES ('47', '管理员', '2015-11-16 15:58:48.207', '管理员', '2015-11-16 15:58:48.207', '0', '10', '001', '001', '1', '吉林省锐迅信息技术股份有限公司', '-1');
INSERT INTO "public"."sys_organization" VALUES ('4501', 'fdad2222', '2015-07-24 16:57:59', '管理员', '2015-07-31 11:40:37', '17', '1', '0101', '0101', '1', '吉林省办事处', '-1');

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_permission";
CREATE TABLE "public"."sys_permission" (
"id" int8 NOT NULL,
"createby" varchar(255) COLLATE "default",
"creationdate" timestamp(6),
"updateby" varchar(255) COLLATE "default",
"updatedate" timestamp(6),
"version_" int8,
"href" varchar(255) COLLATE "default",
"icon" varchar(255) COLLATE "default",
"isshow" bool,
"name" varchar(255) COLLATE "default",
"parentids" varchar(255) COLLATE "default",
"permission" varchar(255) COLLATE "default",
"sort" int4,
"parent_id" int8
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_role";
CREATE TABLE "public"."sys_role" (
"id" int8 NOT NULL,
"createby" varchar(255) COLLATE "default",
"creationdate" timestamp(6),
"updateby" varchar(255) COLLATE "default",
"updatedate" timestamp(6),
"version_" int8,
"name" varchar(255) COLLATE "default",
"remark" varchar(255) COLLATE "default",
"app" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO "public"."sys_role" VALUES ('1212', '管理员', '2015-11-17 02:32:42.692', '管理员', '2015-11-17 02:32:42.707', '3', '超级管理员', '', '系统应用');
INSERT INTO "public"."sys_role" VALUES ('1673', '管理员', '2015-11-17 02:26:43.825', '管理员', '2015-11-17 02:26:43.833', '1', '通用功能普通角色', '协同办公通用功能普通角色', '协同办公');
INSERT INTO "public"."sys_role" VALUES ('1674', '管理员', '2015-11-17 02:26:26.657', '管理员', '2015-11-17 02:26:26.697', '1', '通用功能管理员角色', '协同办公通用功能管理员角色', '协同办公');
INSERT INTO "public"."sys_role" VALUES ('4901', '管理员', '2015-11-17 02:32:34.916', '管理员', '2015-11-17 02:32:34.925', '8', '普通管理员', '222', '系统应用');
INSERT INTO "public"."sys_role" VALUES ('14001', '管理员', '2015-11-17 02:32:26.944', '管理员', '2015-11-17 02:32:26.952', '2', '权限控制管理员', '', '系统应用');
INSERT INTO "public"."sys_role" VALUES ('14002', '管理员', '2015-11-17 02:32:03.415', '管理员', '2015-11-17 02:32:03.429', '2', '系统常量管理员', '', '系统应用');
INSERT INTO "public"."sys_role" VALUES ('19910', '管理员', '2015-11-23 17:52:19.95', '管理员', '2015-11-23 17:52:19.95', '1', '合同管理普通角色', '合同管理模块只能查看的普通角色', '协同办公');
INSERT INTO "public"."sys_role" VALUES ('19911', '管理员', '2015-11-23 17:52:42.651', '管理员', '2015-11-23 17:52:42.651', '1', '合同管理管理员角色', '合同管理模块可以修改的角色', '协同办公');
INSERT INTO "public"."sys_role" VALUES ('19912', '管理员', '2015-11-23 17:53:31.629', '管理员', '2015-11-23 17:53:31.629', '1', '售前服务普通角色', '售前服务只能查看的普通角色', '协同办公');
INSERT INTO "public"."sys_role" VALUES ('19913', '管理员', '2015-11-23 17:53:45.916', '管理员', '2015-11-23 17:53:45.916', '1', '售前服务管理员角色', '售前服务可以修改的管理员角色', '协同办公');
INSERT INTO "public"."sys_role" VALUES ('19914', '管理员', '2015-11-23 17:54:20.618', '管理员', '2015-11-23 17:54:20.618', '1', '项目交付普通角色', '项目交付模块只能查看的普通角色', '协同办公');
INSERT INTO "public"."sys_role" VALUES ('19915', '管理员', '2015-11-23 17:54:36.366', '管理员', '2015-11-23 17:54:36.366', '1', '项目交付管理员角色', '项目交付模块可以修改的管理员角色', '协同办公');
INSERT INTO "public"."sys_role" VALUES ('24810', '管理员', '2015-12-02 10:44:27.22', '管理员', '2015-12-02 10:44:27.22', '1', '统计报表查看角色', '', '协同办公');

-- ----------------------------
-- Table structure for sys_role_application
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_role_application";
CREATE TABLE "public"."sys_role_application" (
"id" int8 NOT NULL,
"createby" varchar(255) COLLATE "default",
"creationdate" timestamp(6),
"updateby" varchar(255) COLLATE "default",
"updatedate" timestamp(6),
"version_" int8,
"applicationid" int8 NOT NULL,
"roleid" int8 NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of sys_role_application
-- ----------------------------
INSERT INTO "public"."sys_role_application" VALUES ('163', 'qwer', '2015-11-16 16:27:12.843', 'qwer', '2015-11-16 16:27:12.843', '0', '7901', '4901');
INSERT INTO "public"."sys_role_application" VALUES ('186', 'qwer', '2015-11-16 16:27:13.015', 'qwer', '2015-11-16 16:27:13.015', '0', '12501', '4901');
INSERT INTO "public"."sys_role_application" VALUES ('193', 'qwer', '2015-11-16 16:27:13.095', 'qwer', '2015-11-16 16:27:13.095', '0', '58', '4901');
INSERT INTO "public"."sys_role_application" VALUES ('404', '管理员', '2015-11-17 00:11:36.699', '管理员', '2015-11-17 00:11:36.699', '0', '7901', '14002');
INSERT INTO "public"."sys_role_application" VALUES ('423', '管理员', '2015-11-17 00:11:36.783', '管理员', '2015-11-17 00:11:36.783', '0', '12501', '14002');
INSERT INTO "public"."sys_role_application" VALUES ('429', '管理员', '2015-11-17 00:11:36.807', '管理员', '2015-11-17 00:11:36.807', '0', '58', '14002');
INSERT INTO "public"."sys_role_application" VALUES ('1787', '管理员', '2015-11-17 01:49:44.206', '管理员', '2015-11-17 01:49:44.206', '0', '58', '1674');
INSERT INTO "public"."sys_role_application" VALUES ('15403', '权限控制人', '2015-08-17 14:01:25', '权限控制人', '2015-08-17 14:01:25', '1', '7901', '14001');
INSERT INTO "public"."sys_role_application" VALUES ('19110', '管理员', '2015-11-23 09:51:04.012', '管理员', '2015-11-23 09:51:04.012', '1', '58', '1673');
INSERT INTO "public"."sys_role_application" VALUES ('20010', '管理员', '2015-11-23 17:55:34.62', '管理员', '2015-11-23 17:55:34.62', '1', '58', '19910');
INSERT INTO "public"."sys_role_application" VALUES ('20011', '管理员', '2015-11-23 17:55:52.985', '管理员', '2015-11-23 17:55:52.985', '1', '58', '19911');
INSERT INTO "public"."sys_role_application" VALUES ('20012', '管理员', '2015-11-23 17:56:21.631', '管理员', '2015-11-23 17:56:21.631', '1', '58', '19912');
INSERT INTO "public"."sys_role_application" VALUES ('20013', '管理员', '2015-11-23 17:56:34.273', '管理员', '2015-11-23 17:56:34.273', '1', '58', '19913');
INSERT INTO "public"."sys_role_application" VALUES ('20014', '管理员', '2015-11-23 17:57:00.889', '管理员', '2015-11-23 17:57:00.889', '1', '58', '19914');
INSERT INTO "public"."sys_role_application" VALUES ('20015', '管理员', '2015-11-23 17:57:15.449', '管理员', '2015-11-23 17:57:15.449', '1', '58', '19915');
INSERT INTO "public"."sys_role_application" VALUES ('25910', '管理员', '2015-12-02 19:51:10.159', '管理员', '2015-12-02 19:51:10.159', '1', '58', '24810');
INSERT INTO "public"."sys_role_application" VALUES ('25911', '管理员', '2015-12-02 19:53:48.705', '管理员', '2015-12-02 19:53:48.705', '1', '7901', '1212');
INSERT INTO "public"."sys_role_application" VALUES ('25912', '管理员', '2015-12-02 19:53:48.763', '管理员', '2015-12-02 19:53:48.763', '1', '58', '1212');
INSERT INTO "public"."sys_role_application" VALUES ('25913', '管理员', '2015-12-02 19:53:49.022', '管理员', '2015-12-02 19:53:49.022', '1', '12501', '1212');

-- ----------------------------
-- Table structure for sys_role_function
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_role_function";
CREATE TABLE "public"."sys_role_function" (
"id" int8 NOT NULL,
"createby" varchar(255) COLLATE "default",
"creationdate" timestamp(6),
"updateby" varchar(255) COLLATE "default",
"updatedate" timestamp(6),
"version_" int8,
"functionid" int8 NOT NULL,
"roleid" int8 NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of sys_role_function
-- ----------------------------
INSERT INTO "public"."sys_role_function" VALUES ('164', 'qwer', '2015-11-16 16:27:12.85', 'qwer', '2015-11-16 16:27:12.85', '0', '13701', '4901');
INSERT INTO "public"."sys_role_function" VALUES ('165', 'qwer', '2015-11-16 16:27:12.854', 'qwer', '2015-11-16 16:27:12.854', '0', '13702', '4901');
INSERT INTO "public"."sys_role_function" VALUES ('166', 'qwer', '2015-11-16 16:27:12.863', 'qwer', '2015-11-16 16:27:12.863', '0', '13703', '4901');
INSERT INTO "public"."sys_role_function" VALUES ('167', 'qwer', '2015-11-16 16:27:12.868', 'qwer', '2015-11-16 16:27:12.868', '0', '14501', '4901');
INSERT INTO "public"."sys_role_function" VALUES ('168', 'qwer', '2015-11-16 16:27:12.872', 'qwer', '2015-11-16 16:27:12.872', '0', '14801', '4901');
INSERT INTO "public"."sys_role_function" VALUES ('169', 'qwer', '2015-11-16 16:27:12.876', 'qwer', '2015-11-16 16:27:12.876', '0', '15101', '4901');
INSERT INTO "public"."sys_role_function" VALUES ('170', 'qwer', '2015-11-16 16:27:12.891', 'qwer', '2015-11-16 16:27:12.891', '0', '15102', '4901');
INSERT INTO "public"."sys_role_function" VALUES ('171', 'qwer', '2015-11-16 16:27:12.898', 'qwer', '2015-11-16 16:27:12.898', '0', '13704', '4901');
INSERT INTO "public"."sys_role_function" VALUES ('172', 'qwer', '2015-11-16 16:27:12.902', 'qwer', '2015-11-16 16:27:12.902', '0', '13705', '4901');
INSERT INTO "public"."sys_role_function" VALUES ('173', 'qwer', '2015-11-16 16:27:12.906', 'qwer', '2015-11-16 16:27:12.906', '0', '13706', '4901');
INSERT INTO "public"."sys_role_function" VALUES ('174', 'qwer', '2015-11-16 16:27:12.914', 'qwer', '2015-11-16 16:27:12.914', '0', '13707', '4901');
INSERT INTO "public"."sys_role_function" VALUES ('175', 'qwer', '2015-11-16 16:27:12.92', 'qwer', '2015-11-16 16:27:12.92', '0', '13708', '4901');
INSERT INTO "public"."sys_role_function" VALUES ('176', 'qwer', '2015-11-16 16:27:12.924', 'qwer', '2015-11-16 16:27:12.924', '0', '13709', '4901');
INSERT INTO "public"."sys_role_function" VALUES ('177', 'qwer', '2015-11-16 16:27:12.93', 'qwer', '2015-11-16 16:27:12.93', '0', '13710', '4901');
INSERT INTO "public"."sys_role_function" VALUES ('178', 'qwer', '2015-11-16 16:27:12.938', 'qwer', '2015-11-16 16:27:12.938', '0', '13711', '4901');
INSERT INTO "public"."sys_role_function" VALUES ('179', 'qwer', '2015-11-16 16:27:12.949', 'qwer', '2015-11-16 16:27:12.949', '0', '13712', '4901');
INSERT INTO "public"."sys_role_function" VALUES ('180', 'qwer', '2015-11-16 16:27:12.953', 'qwer', '2015-11-16 16:27:12.953', '0', '12', '4901');
INSERT INTO "public"."sys_role_function" VALUES ('181', 'qwer', '2015-11-16 16:27:12.957', 'qwer', '2015-11-16 16:27:12.957', '0', '66', '4901');
INSERT INTO "public"."sys_role_function" VALUES ('182', 'qwer', '2015-11-16 16:27:12.968', 'qwer', '2015-11-16 16:27:12.968', '0', '99', '4901');
INSERT INTO "public"."sys_role_function" VALUES ('183', 'qwer', '2015-11-16 16:27:12.973', 'qwer', '2015-11-16 16:27:12.973', '0', '143', '4901');
INSERT INTO "public"."sys_role_function" VALUES ('184', 'qwer', '2015-11-16 16:27:12.99', 'qwer', '2015-11-16 16:27:12.99', '0', '144', '4901');
INSERT INTO "public"."sys_role_function" VALUES ('185', 'qwer', '2015-11-16 16:27:13.006', 'qwer', '2015-11-16 16:27:13.006', '0', '145', '4901');
INSERT INTO "public"."sys_role_function" VALUES ('187', 'qwer', '2015-11-16 16:27:13.025', 'qwer', '2015-11-16 16:27:13.025', '0', '13713', '4901');
INSERT INTO "public"."sys_role_function" VALUES ('188', 'qwer', '2015-11-16 16:27:13.031', 'qwer', '2015-11-16 16:27:13.031', '0', '13714', '4901');
INSERT INTO "public"."sys_role_function" VALUES ('189', 'qwer', '2015-11-16 16:27:13.036', 'qwer', '2015-11-16 16:27:13.036', '0', '13715', '4901');
INSERT INTO "public"."sys_role_function" VALUES ('190', 'qwer', '2015-11-16 16:27:13.045', 'qwer', '2015-11-16 16:27:13.045', '0', '13716', '4901');
INSERT INTO "public"."sys_role_function" VALUES ('191', 'qwer', '2015-11-16 16:27:13.06', 'qwer', '2015-11-16 16:27:13.06', '0', '13717', '4901');
INSERT INTO "public"."sys_role_function" VALUES ('192', 'qwer', '2015-11-16 16:27:13.09', 'qwer', '2015-11-16 16:27:13.09', '0', '13718', '4901');
INSERT INTO "public"."sys_role_function" VALUES ('194', 'qwer', '2015-11-16 16:27:13.101', 'qwer', '2015-11-16 16:27:13.101', '0', '59', '4901');
INSERT INTO "public"."sys_role_function" VALUES ('195', 'qwer', '2015-11-16 16:27:13.105', 'qwer', '2015-11-16 16:27:13.105', '0', '60', '4901');
INSERT INTO "public"."sys_role_function" VALUES ('196', 'qwer', '2015-11-16 16:27:13.11', 'qwer', '2015-11-16 16:27:13.11', '0', '62', '4901');
INSERT INTO "public"."sys_role_function" VALUES ('405', '管理员', '2015-11-17 00:11:36.703', '管理员', '2015-11-17 00:11:36.703', '0', '209', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('406', '管理员', '2015-11-17 00:11:36.714', '管理员', '2015-11-17 00:11:36.714', '0', '211', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('407', '管理员', '2015-11-17 00:11:36.719', '管理员', '2015-11-17 00:11:36.719', '0', '212', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('408', '管理员', '2015-11-17 00:11:36.722', '管理员', '2015-11-17 00:11:36.722', '0', '210', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('409', '管理员', '2015-11-17 00:11:36.726', '管理员', '2015-11-17 00:11:36.726', '0', '279', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('410', '管理员', '2015-11-17 00:11:36.73', '管理员', '2015-11-17 00:11:36.73', '0', '280', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('411', '管理员', '2015-11-17 00:11:36.733', '管理员', '2015-11-17 00:11:36.733', '0', '282', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('412', '管理员', '2015-11-17 00:11:36.737', '管理员', '2015-11-17 00:11:36.737', '0', '281', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('413', '管理员', '2015-11-17 00:11:36.74', '管理员', '2015-11-17 00:11:36.74', '0', '208', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('414', '管理员', '2015-11-17 00:11:36.745', '管理员', '2015-11-17 00:11:36.745', '0', '213', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('415', '管理员', '2015-11-17 00:11:36.75', '管理员', '2015-11-17 00:11:36.75', '0', '214', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('416', '管理员', '2015-11-17 00:11:36.753', '管理员', '2015-11-17 00:11:36.753', '0', '215', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('417', '管理员', '2015-11-17 00:11:36.757', '管理员', '2015-11-17 00:11:36.757', '0', '207', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('418', '管理员', '2015-11-17 00:11:36.761', '管理员', '2015-11-17 00:11:36.761', '0', '216', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('419', '管理员', '2015-11-17 00:11:36.767', '管理员', '2015-11-17 00:11:36.767', '0', '217', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('420', '管理员', '2015-11-17 00:11:36.771', '管理员', '2015-11-17 00:11:36.771', '0', '250', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('421', '管理员', '2015-11-17 00:11:36.775', '管理员', '2015-11-17 00:11:36.775', '0', '251', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('422', '管理员', '2015-11-17 00:11:36.779', '管理员', '2015-11-17 00:11:36.779', '0', '252', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('424', '管理员', '2015-11-17 00:11:36.787', '管理员', '2015-11-17 00:11:36.787', '0', '13713', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('425', '管理员', '2015-11-17 00:11:36.791', '管理员', '2015-11-17 00:11:36.791', '0', '275', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('426', '管理员', '2015-11-17 00:11:36.795', '管理员', '2015-11-17 00:11:36.795', '0', '276', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('427', '管理员', '2015-11-17 00:11:36.798', '管理员', '2015-11-17 00:11:36.798', '0', '277', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('428', '管理员', '2015-11-17 00:11:36.804', '管理员', '2015-11-17 00:11:36.804', '0', '278', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('430', '管理员', '2015-11-17 00:11:36.811', '管理员', '2015-11-17 00:11:36.811', '0', '59', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('431', '管理员', '2015-11-17 00:11:36.815', '管理员', '2015-11-17 00:11:36.815', '0', '60', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('432', '管理员', '2015-11-17 00:11:36.819', '管理员', '2015-11-17 00:11:36.819', '0', '352', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('433', '管理员', '2015-11-17 00:11:36.823', '管理员', '2015-11-17 00:11:36.823', '0', '353', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('434', '管理员', '2015-11-17 00:11:36.828', '管理员', '2015-11-17 00:11:36.828', '0', '354', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('435', '管理员', '2015-11-17 00:11:36.835', '管理员', '2015-11-17 00:11:36.835', '0', '355', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('436', '管理员', '2015-11-17 00:11:36.838', '管理员', '2015-11-17 00:11:36.838', '0', '61', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('437', '管理员', '2015-11-17 00:11:36.843', '管理员', '2015-11-17 00:11:36.843', '0', '356', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('438', '管理员', '2015-11-17 00:11:36.847', '管理员', '2015-11-17 00:11:36.847', '0', '357', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('439', '管理员', '2015-11-17 00:11:36.85', '管理员', '2015-11-17 00:11:36.85', '0', '358', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('440', '管理员', '2015-11-17 00:11:36.854', '管理员', '2015-11-17 00:11:36.854', '0', '359', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('441', '管理员', '2015-11-17 00:11:36.858', '管理员', '2015-11-17 00:11:36.858', '0', '62', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('442', '管理员', '2015-11-17 00:11:36.861', '管理员', '2015-11-17 00:11:36.861', '0', '360', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('443', '管理员', '2015-11-17 00:11:36.866', '管理员', '2015-11-17 00:11:36.866', '0', '361', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('444', '管理员', '2015-11-17 00:11:36.87', '管理员', '2015-11-17 00:11:36.87', '0', '362', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('445', '管理员', '2015-11-17 00:11:36.873', '管理员', '2015-11-17 00:11:36.873', '0', '363', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('446', '管理员', '2015-11-17 00:11:36.877', '管理员', '2015-11-17 00:11:36.877', '0', '339', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('447', '管理员', '2015-11-17 00:11:36.881', '管理员', '2015-11-17 00:11:36.881', '0', '342', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('448', '管理员', '2015-11-17 00:11:36.884', '管理员', '2015-11-17 00:11:36.884', '0', '364', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('449', '管理员', '2015-11-17 00:11:36.888', '管理员', '2015-11-17 00:11:36.888', '0', '365', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('450', '管理员', '2015-11-17 00:11:36.891', '管理员', '2015-11-17 00:11:36.891', '0', '366', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('451', '管理员', '2015-11-17 00:11:36.896', '管理员', '2015-11-17 00:11:36.896', '0', '367', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('452', '管理员', '2015-11-17 00:11:36.899', '管理员', '2015-11-17 00:11:36.899', '0', '343', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('453', '管理员', '2015-11-17 00:11:36.903', '管理员', '2015-11-17 00:11:36.903', '0', '368', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('454', '管理员', '2015-11-17 00:11:36.909', '管理员', '2015-11-17 00:11:36.909', '0', '369', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('455', '管理员', '2015-11-17 00:11:36.914', '管理员', '2015-11-17 00:11:36.914', '0', '370', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('456', '管理员', '2015-11-17 00:11:36.918', '管理员', '2015-11-17 00:11:36.918', '0', '371', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('457', '管理员', '2015-11-17 00:11:36.921', '管理员', '2015-11-17 00:11:36.921', '0', '340', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('458', '管理员', '2015-11-17 00:11:36.924', '管理员', '2015-11-17 00:11:36.924', '0', '345', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('459', '管理员', '2015-11-17 00:11:36.929', '管理员', '2015-11-17 00:11:36.929', '0', '372', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('460', '管理员', '2015-11-17 00:11:36.933', '管理员', '2015-11-17 00:11:36.933', '0', '373', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('461', '管理员', '2015-11-17 00:11:36.938', '管理员', '2015-11-17 00:11:36.938', '0', '374', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('462', '管理员', '2015-11-17 00:11:36.941', '管理员', '2015-11-17 00:11:36.941', '0', '375', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('463', '管理员', '2015-11-17 00:11:36.947', '管理员', '2015-11-17 00:11:36.947', '0', '346', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('464', '管理员', '2015-11-17 00:11:36.951', '管理员', '2015-11-17 00:11:36.951', '0', '376', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('465', '管理员', '2015-11-17 00:11:36.955', '管理员', '2015-11-17 00:11:36.955', '0', '377', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('466', '管理员', '2015-11-17 00:11:36.958', '管理员', '2015-11-17 00:11:36.958', '0', '378', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('467', '管理员', '2015-11-17 00:11:36.962', '管理员', '2015-11-17 00:11:36.962', '0', '379', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('468', '管理员', '2015-11-17 00:11:36.966', '管理员', '2015-11-17 00:11:36.966', '0', '344', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('469', '管理员', '2015-11-17 00:11:36.969', '管理员', '2015-11-17 00:11:36.969', '0', '380', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('470', '管理员', '2015-11-17 00:11:36.973', '管理员', '2015-11-17 00:11:36.973', '0', '381', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('471', '管理员', '2015-11-17 00:11:36.978', '管理员', '2015-11-17 00:11:36.978', '0', '382', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('472', '管理员', '2015-11-17 00:11:36.981', '管理员', '2015-11-17 00:11:36.981', '0', '383', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('473', '管理员', '2015-11-17 00:11:36.985', '管理员', '2015-11-17 00:11:36.985', '0', '347', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('474', '管理员', '2015-11-17 00:11:36.989', '管理员', '2015-11-17 00:11:36.989', '0', '384', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('475', '管理员', '2015-11-17 00:11:36.993', '管理员', '2015-11-17 00:11:36.993', '0', '385', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('476', '管理员', '2015-11-17 00:11:36.996', '管理员', '2015-11-17 00:11:36.996', '0', '386', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('477', '管理员', '2015-11-17 00:11:37', '管理员', '2015-11-17 00:11:37', '0', '387', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('478', '管理员', '2015-11-17 00:11:37.004', '管理员', '2015-11-17 00:11:37.004', '0', '341', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('479', '管理员', '2015-11-17 00:11:37.007', '管理员', '2015-11-17 00:11:37.007', '0', '348', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('480', '管理员', '2015-11-17 00:11:37.011', '管理员', '2015-11-17 00:11:37.011', '0', '388', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('481', '管理员', '2015-11-17 00:11:37.015', '管理员', '2015-11-17 00:11:37.015', '0', '389', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('482', '管理员', '2015-11-17 00:11:37.018', '管理员', '2015-11-17 00:11:37.018', '0', '390', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('483', '管理员', '2015-11-17 00:11:37.022', '管理员', '2015-11-17 00:11:37.022', '0', '391', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('484', '管理员', '2015-11-17 00:11:37.026', '管理员', '2015-11-17 00:11:37.026', '0', '349', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('485', '管理员', '2015-11-17 00:11:37.029', '管理员', '2015-11-17 00:11:37.029', '0', '392', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('486', '管理员', '2015-11-17 00:11:37.033', '管理员', '2015-11-17 00:11:37.033', '0', '393', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('487', '管理员', '2015-11-17 00:11:37.036', '管理员', '2015-11-17 00:11:37.036', '0', '394', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('488', '管理员', '2015-11-17 00:11:37.04', '管理员', '2015-11-17 00:11:37.04', '0', '395', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('489', '管理员', '2015-11-17 00:11:37.043', '管理员', '2015-11-17 00:11:37.043', '0', '350', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('490', '管理员', '2015-11-17 00:11:37.046', '管理员', '2015-11-17 00:11:37.046', '0', '396', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('491', '管理员', '2015-11-17 00:11:37.05', '管理员', '2015-11-17 00:11:37.05', '0', '397', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('492', '管理员', '2015-11-17 00:11:37.054', '管理员', '2015-11-17 00:11:37.054', '0', '398', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('493', '管理员', '2015-11-17 00:11:37.057', '管理员', '2015-11-17 00:11:37.057', '0', '399', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('494', '管理员', '2015-11-17 00:11:37.06', '管理员', '2015-11-17 00:11:37.06', '0', '351', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('495', '管理员', '2015-11-17 00:11:37.064', '管理员', '2015-11-17 00:11:37.064', '0', '400', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('496', '管理员', '2015-11-17 00:11:37.067', '管理员', '2015-11-17 00:11:37.067', '0', '401', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('497', '管理员', '2015-11-17 00:11:37.071', '管理员', '2015-11-17 00:11:37.071', '0', '402', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('498', '管理员', '2015-11-17 00:11:37.074', '管理员', '2015-11-17 00:11:37.074', '0', '403', '14002');
INSERT INTO "public"."sys_role_function" VALUES ('1788', '管理员', '2015-11-17 01:49:44.21', '管理员', '2015-11-17 01:49:44.21', '0', '339', '1674');
INSERT INTO "public"."sys_role_function" VALUES ('1789', '管理员', '2015-11-17 01:49:44.214', '管理员', '2015-11-17 01:49:44.214', '0', '342', '1674');
INSERT INTO "public"."sys_role_function" VALUES ('1790', '管理员', '2015-11-17 01:49:44.218', '管理员', '2015-11-17 01:49:44.218', '0', '364', '1674');
INSERT INTO "public"."sys_role_function" VALUES ('1791', '管理员', '2015-11-17 01:49:44.224', '管理员', '2015-11-17 01:49:44.224', '0', '365', '1674');
INSERT INTO "public"."sys_role_function" VALUES ('1792', '管理员', '2015-11-17 01:49:44.228', '管理员', '2015-11-17 01:49:44.228', '0', '366', '1674');
INSERT INTO "public"."sys_role_function" VALUES ('1793', '管理员', '2015-11-17 01:49:44.232', '管理员', '2015-11-17 01:49:44.232', '0', '367', '1674');
INSERT INTO "public"."sys_role_function" VALUES ('1794', '管理员', '2015-11-17 01:49:44.235', '管理员', '2015-11-17 01:49:44.235', '0', '343', '1674');
INSERT INTO "public"."sys_role_function" VALUES ('1795', '管理员', '2015-11-17 01:49:44.239', '管理员', '2015-11-17 01:49:44.239', '0', '368', '1674');
INSERT INTO "public"."sys_role_function" VALUES ('1796', '管理员', '2015-11-17 01:49:44.243', '管理员', '2015-11-17 01:49:44.243', '0', '369', '1674');
INSERT INTO "public"."sys_role_function" VALUES ('1797', '管理员', '2015-11-17 01:49:44.246', '管理员', '2015-11-17 01:49:44.246', '0', '370', '1674');
INSERT INTO "public"."sys_role_function" VALUES ('1798', '管理员', '2015-11-17 01:49:44.249', '管理员', '2015-11-17 01:49:44.249', '0', '371', '1674');
INSERT INTO "public"."sys_role_function" VALUES ('15520', '权限控制人', '2015-08-17 14:01:25', '权限控制人', '2015-08-17 14:01:25', '1', '13701', '14001');
INSERT INTO "public"."sys_role_function" VALUES ('15521', '权限控制人', '2015-08-17 14:01:25', '权限控制人', '2015-08-17 14:01:25', '1', '13702', '14001');
INSERT INTO "public"."sys_role_function" VALUES ('15522', '权限控制人', '2015-08-17 14:01:25', '权限控制人', '2015-08-17 14:01:25', '1', '13703', '14001');
INSERT INTO "public"."sys_role_function" VALUES ('15523', '权限控制人', '2015-08-17 14:01:25', '权限控制人', '2015-08-17 14:01:25', '1', '14501', '14001');
INSERT INTO "public"."sys_role_function" VALUES ('15524', '权限控制人', '2015-08-17 14:01:25', '权限控制人', '2015-08-17 14:01:25', '1', '14801', '14001');
INSERT INTO "public"."sys_role_function" VALUES ('15525', '权限控制人', '2015-08-17 14:01:25', '权限控制人', '2015-08-17 14:01:25', '1', '15101', '14001');
INSERT INTO "public"."sys_role_function" VALUES ('15526', '权限控制人', '2015-08-17 14:01:25', '权限控制人', '2015-08-17 14:01:25', '1', '13704', '14001');
INSERT INTO "public"."sys_role_function" VALUES ('15527', '权限控制人', '2015-08-17 14:01:25', '权限控制人', '2015-08-17 14:01:25', '1', '13705', '14001');
INSERT INTO "public"."sys_role_function" VALUES ('15528', '权限控制人', '2015-08-17 14:01:25', '权限控制人', '2015-08-17 14:01:25', '1', '13706', '14001');
INSERT INTO "public"."sys_role_function" VALUES ('15529', '权限控制人', '2015-08-17 14:01:25', '权限控制人', '2015-08-17 14:01:25', '1', '13707', '14001');
INSERT INTO "public"."sys_role_function" VALUES ('19210', '管理员', '2015-11-23 09:51:04.023', '管理员', '2015-11-23 09:51:04.023', '1', '339', '1673');
INSERT INTO "public"."sys_role_function" VALUES ('19211', '管理员', '2015-11-23 09:51:04.036', '管理员', '2015-11-23 09:51:04.036', '1', '342', '1673');
INSERT INTO "public"."sys_role_function" VALUES ('19212', '管理员', '2015-11-23 09:51:04.041', '管理员', '2015-11-23 09:51:04.041', '1', '367', '1673');
INSERT INTO "public"."sys_role_function" VALUES ('19213', '管理员', '2015-11-23 09:51:04.047', '管理员', '2015-11-23 09:51:04.047', '1', '343', '1673');
INSERT INTO "public"."sys_role_function" VALUES ('19214', '管理员', '2015-11-23 09:51:04.051', '管理员', '2015-11-23 09:51:04.051', '1', '371', '1673');
INSERT INTO "public"."sys_role_function" VALUES ('20110', '管理员', '2015-11-23 17:55:34.632', '管理员', '2015-11-23 17:55:34.632', '1', '59', '19910');
INSERT INTO "public"."sys_role_function" VALUES ('20111', '管理员', '2015-11-23 17:55:34.639', '管理员', '2015-11-23 17:55:34.639', '1', '60', '19910');
INSERT INTO "public"."sys_role_function" VALUES ('20112', '管理员', '2015-11-23 17:55:34.642', '管理员', '2015-11-23 17:55:34.642', '1', '355', '19910');
INSERT INTO "public"."sys_role_function" VALUES ('20113', '管理员', '2015-11-23 17:55:34.645', '管理员', '2015-11-23 17:55:34.645', '1', '61', '19910');
INSERT INTO "public"."sys_role_function" VALUES ('20114', '管理员', '2015-11-23 17:55:34.649', '管理员', '2015-11-23 17:55:34.649', '1', '359', '19910');
INSERT INTO "public"."sys_role_function" VALUES ('20115', '管理员', '2015-11-23 17:55:34.652', '管理员', '2015-11-23 17:55:34.652', '1', '62', '19910');
INSERT INTO "public"."sys_role_function" VALUES ('20116', '管理员', '2015-11-23 17:55:34.655', '管理员', '2015-11-23 17:55:34.655', '1', '363', '19910');
INSERT INTO "public"."sys_role_function" VALUES ('20117', '管理员', '2015-11-23 17:55:52.992', '管理员', '2015-11-23 17:55:52.992', '1', '59', '19911');
INSERT INTO "public"."sys_role_function" VALUES ('20118', '管理员', '2015-11-23 17:55:52.996', '管理员', '2015-11-23 17:55:52.996', '1', '60', '19911');
INSERT INTO "public"."sys_role_function" VALUES ('20119', '管理员', '2015-11-23 17:55:52.999', '管理员', '2015-11-23 17:55:52.999', '1', '352', '19911');
INSERT INTO "public"."sys_role_function" VALUES ('20120', '管理员', '2015-11-23 17:55:53.002', '管理员', '2015-11-23 17:55:53.002', '1', '353', '19911');
INSERT INTO "public"."sys_role_function" VALUES ('20121', '管理员', '2015-11-23 17:55:53.005', '管理员', '2015-11-23 17:55:53.005', '1', '355', '19911');
INSERT INTO "public"."sys_role_function" VALUES ('20122', '管理员', '2015-11-23 17:55:53.008', '管理员', '2015-11-23 17:55:53.008', '1', '354', '19911');
INSERT INTO "public"."sys_role_function" VALUES ('20123', '管理员', '2015-11-23 17:55:53.011', '管理员', '2015-11-23 17:55:53.011', '1', '61', '19911');
INSERT INTO "public"."sys_role_function" VALUES ('20124', '管理员', '2015-11-23 17:55:53.014', '管理员', '2015-11-23 17:55:53.014', '1', '356', '19911');
INSERT INTO "public"."sys_role_function" VALUES ('20125', '管理员', '2015-11-23 17:55:53.017', '管理员', '2015-11-23 17:55:53.017', '1', '357', '19911');
INSERT INTO "public"."sys_role_function" VALUES ('20126', '管理员', '2015-11-23 17:55:53.02', '管理员', '2015-11-23 17:55:53.02', '1', '358', '19911');
INSERT INTO "public"."sys_role_function" VALUES ('20127', '管理员', '2015-11-23 17:55:53.023', '管理员', '2015-11-23 17:55:53.023', '1', '359', '19911');
INSERT INTO "public"."sys_role_function" VALUES ('20128', '管理员', '2015-11-23 17:55:53.026', '管理员', '2015-11-23 17:55:53.026', '1', '62', '19911');
INSERT INTO "public"."sys_role_function" VALUES ('20129', '管理员', '2015-11-23 17:55:53.03', '管理员', '2015-11-23 17:55:53.03', '1', '360', '19911');
INSERT INTO "public"."sys_role_function" VALUES ('20130', '管理员', '2015-11-23 17:55:53.032', '管理员', '2015-11-23 17:55:53.032', '1', '361', '19911');
INSERT INTO "public"."sys_role_function" VALUES ('20131', '管理员', '2015-11-23 17:55:53.035', '管理员', '2015-11-23 17:55:53.035', '1', '362', '19911');
INSERT INTO "public"."sys_role_function" VALUES ('20132', '管理员', '2015-11-23 17:55:53.038', '管理员', '2015-11-23 17:55:53.038', '1', '363', '19911');
INSERT INTO "public"."sys_role_function" VALUES ('20133', '管理员', '2015-11-23 17:56:21.638', '管理员', '2015-11-23 17:56:21.638', '1', '340', '19912');
INSERT INTO "public"."sys_role_function" VALUES ('20134', '管理员', '2015-11-23 17:56:21.641', '管理员', '2015-11-23 17:56:21.641', '1', '345', '19912');
INSERT INTO "public"."sys_role_function" VALUES ('20135', '管理员', '2015-11-23 17:56:21.645', '管理员', '2015-11-23 17:56:21.645', '1', '375', '19912');
INSERT INTO "public"."sys_role_function" VALUES ('20136', '管理员', '2015-11-23 17:56:21.648', '管理员', '2015-11-23 17:56:21.648', '1', '346', '19912');
INSERT INTO "public"."sys_role_function" VALUES ('20137', '管理员', '2015-11-23 17:56:21.651', '管理员', '2015-11-23 17:56:21.651', '1', '379', '19912');
INSERT INTO "public"."sys_role_function" VALUES ('20138', '管理员', '2015-11-23 17:56:21.654', '管理员', '2015-11-23 17:56:21.654', '1', '344', '19912');
INSERT INTO "public"."sys_role_function" VALUES ('20139', '管理员', '2015-11-23 17:56:21.657', '管理员', '2015-11-23 17:56:21.657', '1', '383', '19912');
INSERT INTO "public"."sys_role_function" VALUES ('20140', '管理员', '2015-11-23 17:56:21.66', '管理员', '2015-11-23 17:56:21.66', '1', '347', '19912');
INSERT INTO "public"."sys_role_function" VALUES ('20141', '管理员', '2015-11-23 17:56:21.663', '管理员', '2015-11-23 17:56:21.663', '1', '387', '19912');
INSERT INTO "public"."sys_role_function" VALUES ('20142', '管理员', '2015-11-23 17:56:34.279', '管理员', '2015-11-23 17:56:34.279', '1', '340', '19913');
INSERT INTO "public"."sys_role_function" VALUES ('20143', '管理员', '2015-11-23 17:56:34.284', '管理员', '2015-11-23 17:56:34.284', '1', '345', '19913');
INSERT INTO "public"."sys_role_function" VALUES ('20144', '管理员', '2015-11-23 17:56:34.287', '管理员', '2015-11-23 17:56:34.287', '1', '372', '19913');
INSERT INTO "public"."sys_role_function" VALUES ('20145', '管理员', '2015-11-23 17:56:34.29', '管理员', '2015-11-23 17:56:34.29', '1', '373', '19913');
INSERT INTO "public"."sys_role_function" VALUES ('20146', '管理员', '2015-11-23 17:56:34.293', '管理员', '2015-11-23 17:56:34.293', '1', '374', '19913');
INSERT INTO "public"."sys_role_function" VALUES ('20147', '管理员', '2015-11-23 17:56:34.296', '管理员', '2015-11-23 17:56:34.296', '1', '375', '19913');
INSERT INTO "public"."sys_role_function" VALUES ('20148', '管理员', '2015-11-23 17:56:34.299', '管理员', '2015-11-23 17:56:34.299', '1', '346', '19913');
INSERT INTO "public"."sys_role_function" VALUES ('20149', '管理员', '2015-11-23 17:56:34.302', '管理员', '2015-11-23 17:56:34.302', '1', '376', '19913');
INSERT INTO "public"."sys_role_function" VALUES ('20150', '管理员', '2015-11-23 17:56:34.305', '管理员', '2015-11-23 17:56:34.305', '1', '377', '19913');
INSERT INTO "public"."sys_role_function" VALUES ('20151', '管理员', '2015-11-23 17:56:34.308', '管理员', '2015-11-23 17:56:34.308', '1', '378', '19913');
INSERT INTO "public"."sys_role_function" VALUES ('20152', '管理员', '2015-11-23 17:56:34.31', '管理员', '2015-11-23 17:56:34.31', '1', '379', '19913');
INSERT INTO "public"."sys_role_function" VALUES ('20153', '管理员', '2015-11-23 17:56:34.313', '管理员', '2015-11-23 17:56:34.313', '1', '344', '19913');
INSERT INTO "public"."sys_role_function" VALUES ('20154', '管理员', '2015-11-23 17:56:34.316', '管理员', '2015-11-23 17:56:34.316', '1', '380', '19913');
INSERT INTO "public"."sys_role_function" VALUES ('20155', '管理员', '2015-11-23 17:56:34.319', '管理员', '2015-11-23 17:56:34.319', '1', '381', '19913');
INSERT INTO "public"."sys_role_function" VALUES ('20156', '管理员', '2015-11-23 17:56:34.322', '管理员', '2015-11-23 17:56:34.322', '1', '382', '19913');
INSERT INTO "public"."sys_role_function" VALUES ('20157', '管理员', '2015-11-23 17:56:34.324', '管理员', '2015-11-23 17:56:34.324', '1', '383', '19913');
INSERT INTO "public"."sys_role_function" VALUES ('20158', '管理员', '2015-11-23 17:56:34.327', '管理员', '2015-11-23 17:56:34.327', '1', '347', '19913');
INSERT INTO "public"."sys_role_function" VALUES ('20159', '管理员', '2015-11-23 17:56:34.33', '管理员', '2015-11-23 17:56:34.33', '1', '384', '19913');
INSERT INTO "public"."sys_role_function" VALUES ('20160', '管理员', '2015-11-23 17:56:34.332', '管理员', '2015-11-23 17:56:34.332', '1', '385', '19913');
INSERT INTO "public"."sys_role_function" VALUES ('20161', '管理员', '2015-11-23 17:56:34.335', '管理员', '2015-11-23 17:56:34.335', '1', '386', '19913');
INSERT INTO "public"."sys_role_function" VALUES ('20162', '管理员', '2015-11-23 17:56:34.338', '管理员', '2015-11-23 17:56:34.338', '1', '387', '19913');
INSERT INTO "public"."sys_role_function" VALUES ('20163', '管理员', '2015-11-23 17:57:00.896', '管理员', '2015-11-23 17:57:00.896', '1', '341', '19914');
INSERT INTO "public"."sys_role_function" VALUES ('20164', '管理员', '2015-11-23 17:57:00.899', '管理员', '2015-11-23 17:57:00.899', '1', '348', '19914');
INSERT INTO "public"."sys_role_function" VALUES ('20165', '管理员', '2015-11-23 17:57:00.903', '管理员', '2015-11-23 17:57:00.903', '1', '391', '19914');
INSERT INTO "public"."sys_role_function" VALUES ('20166', '管理员', '2015-11-23 17:57:00.906', '管理员', '2015-11-23 17:57:00.906', '1', '349', '19914');
INSERT INTO "public"."sys_role_function" VALUES ('20167', '管理员', '2015-11-23 17:57:00.909', '管理员', '2015-11-23 17:57:00.909', '1', '395', '19914');
INSERT INTO "public"."sys_role_function" VALUES ('20168', '管理员', '2015-11-23 17:57:00.912', '管理员', '2015-11-23 17:57:00.912', '1', '350', '19914');
INSERT INTO "public"."sys_role_function" VALUES ('20169', '管理员', '2015-11-23 17:57:00.916', '管理员', '2015-11-23 17:57:00.916', '1', '399', '19914');
INSERT INTO "public"."sys_role_function" VALUES ('20170', '管理员', '2015-11-23 17:57:00.919', '管理员', '2015-11-23 17:57:00.919', '1', '351', '19914');
INSERT INTO "public"."sys_role_function" VALUES ('20171', '管理员', '2015-11-23 17:57:00.922', '管理员', '2015-11-23 17:57:00.922', '1', '403', '19914');
INSERT INTO "public"."sys_role_function" VALUES ('20172', '管理员', '2015-11-23 17:57:15.457', '管理员', '2015-11-23 17:57:15.457', '1', '341', '19915');
INSERT INTO "public"."sys_role_function" VALUES ('20173', '管理员', '2015-11-23 17:57:15.46', '管理员', '2015-11-23 17:57:15.46', '1', '348', '19915');
INSERT INTO "public"."sys_role_function" VALUES ('20174', '管理员', '2015-11-23 17:57:15.463', '管理员', '2015-11-23 17:57:15.463', '1', '388', '19915');
INSERT INTO "public"."sys_role_function" VALUES ('20175', '管理员', '2015-11-23 17:57:15.466', '管理员', '2015-11-23 17:57:15.466', '1', '389', '19915');
INSERT INTO "public"."sys_role_function" VALUES ('20176', '管理员', '2015-11-23 17:57:15.469', '管理员', '2015-11-23 17:57:15.469', '1', '390', '19915');
INSERT INTO "public"."sys_role_function" VALUES ('20177', '管理员', '2015-11-23 17:57:15.472', '管理员', '2015-11-23 17:57:15.472', '1', '391', '19915');
INSERT INTO "public"."sys_role_function" VALUES ('20178', '管理员', '2015-11-23 17:57:15.475', '管理员', '2015-11-23 17:57:15.475', '1', '349', '19915');
INSERT INTO "public"."sys_role_function" VALUES ('20179', '管理员', '2015-11-23 17:57:15.478', '管理员', '2015-11-23 17:57:15.478', '1', '392', '19915');
INSERT INTO "public"."sys_role_function" VALUES ('20180', '管理员', '2015-11-23 17:57:15.481', '管理员', '2015-11-23 17:57:15.481', '1', '393', '19915');
INSERT INTO "public"."sys_role_function" VALUES ('20181', '管理员', '2015-11-23 17:57:15.484', '管理员', '2015-11-23 17:57:15.484', '1', '394', '19915');
INSERT INTO "public"."sys_role_function" VALUES ('20182', '管理员', '2015-11-23 17:57:15.486', '管理员', '2015-11-23 17:57:15.486', '1', '395', '19915');
INSERT INTO "public"."sys_role_function" VALUES ('20183', '管理员', '2015-11-23 17:57:15.489', '管理员', '2015-11-23 17:57:15.489', '1', '350', '19915');
INSERT INTO "public"."sys_role_function" VALUES ('20184', '管理员', '2015-11-23 17:57:15.493', '管理员', '2015-11-23 17:57:15.493', '1', '396', '19915');
INSERT INTO "public"."sys_role_function" VALUES ('20185', '管理员', '2015-11-23 17:57:15.496', '管理员', '2015-11-23 17:57:15.496', '1', '397', '19915');
INSERT INTO "public"."sys_role_function" VALUES ('20186', '管理员', '2015-11-23 17:57:15.498', '管理员', '2015-11-23 17:57:15.498', '1', '398', '19915');
INSERT INTO "public"."sys_role_function" VALUES ('20187', '管理员', '2015-11-23 17:57:15.501', '管理员', '2015-11-23 17:57:15.501', '1', '399', '19915');
INSERT INTO "public"."sys_role_function" VALUES ('20188', '管理员', '2015-11-23 17:57:15.504', '管理员', '2015-11-23 17:57:15.504', '1', '351', '19915');
INSERT INTO "public"."sys_role_function" VALUES ('20189', '管理员', '2015-11-23 17:57:15.507', '管理员', '2015-11-23 17:57:15.507', '1', '400', '19915');
INSERT INTO "public"."sys_role_function" VALUES ('20190', '管理员', '2015-11-23 17:57:15.51', '管理员', '2015-11-23 17:57:15.51', '1', '401', '19915');
INSERT INTO "public"."sys_role_function" VALUES ('20191', '管理员', '2015-11-23 17:57:15.513', '管理员', '2015-11-23 17:57:15.513', '1', '402', '19915');
INSERT INTO "public"."sys_role_function" VALUES ('20192', '管理员', '2015-11-23 17:57:15.515', '管理员', '2015-11-23 17:57:15.515', '1', '403', '19915');
INSERT INTO "public"."sys_role_function" VALUES ('26010', '管理员', '2015-12-02 19:51:10.166', '管理员', '2015-12-02 19:51:10.166', '1', '24710', '24810');
INSERT INTO "public"."sys_role_function" VALUES ('26011', '管理员', '2015-12-02 19:51:10.172', '管理员', '2015-12-02 19:51:10.172', '1', '24711', '24810');
INSERT INTO "public"."sys_role_function" VALUES ('26012', '管理员', '2015-12-02 19:51:10.175', '管理员', '2015-12-02 19:51:10.175', '1', '25810', '24810');
INSERT INTO "public"."sys_role_function" VALUES ('26013', '管理员', '2015-12-02 19:53:48.709', '管理员', '2015-12-02 19:53:48.709', '1', '209', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26014', '管理员', '2015-12-02 19:53:48.713', '管理员', '2015-12-02 19:53:48.713', '1', '211', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26015', '管理员', '2015-12-02 19:53:48.716', '管理员', '2015-12-02 19:53:48.716', '1', '212', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26016', '管理员', '2015-12-02 19:53:48.719', '管理员', '2015-12-02 19:53:48.719', '1', '210', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26017', '管理员', '2015-12-02 19:53:48.721', '管理员', '2015-12-02 19:53:48.721', '1', '279', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26018', '管理员', '2015-12-02 19:53:48.725', '管理员', '2015-12-02 19:53:48.725', '1', '280', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26019', '管理员', '2015-12-02 19:53:48.727', '管理员', '2015-12-02 19:53:48.727', '1', '282', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26020', '管理员', '2015-12-02 19:53:48.73', '管理员', '2015-12-02 19:53:48.73', '1', '281', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26021', '管理员', '2015-12-02 19:53:48.734', '管理员', '2015-12-02 19:53:48.734', '1', '208', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26022', '管理员', '2015-12-02 19:53:48.737', '管理员', '2015-12-02 19:53:48.737', '1', '214', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26023', '管理员', '2015-12-02 19:53:48.74', '管理员', '2015-12-02 19:53:48.74', '1', '215', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26024', '管理员', '2015-12-02 19:53:48.743', '管理员', '2015-12-02 19:53:48.743', '1', '213', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26025', '管理员', '2015-12-02 19:53:48.746', '管理员', '2015-12-02 19:53:48.746', '1', '207', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26026', '管理员', '2015-12-02 19:53:48.748', '管理员', '2015-12-02 19:53:48.748', '1', '216', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26027', '管理员', '2015-12-02 19:53:48.751', '管理员', '2015-12-02 19:53:48.751', '1', '217', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26028', '管理员', '2015-12-02 19:53:48.754', '管理员', '2015-12-02 19:53:48.754', '1', '250', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26029', '管理员', '2015-12-02 19:53:48.757', '管理员', '2015-12-02 19:53:48.757', '1', '251', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26030', '管理员', '2015-12-02 19:53:48.76', '管理员', '2015-12-02 19:53:48.76', '1', '252', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26031', '管理员', '2015-12-02 19:53:48.766', '管理员', '2015-12-02 19:53:48.766', '1', '339', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26032', '管理员', '2015-12-02 19:53:48.769', '管理员', '2015-12-02 19:53:48.769', '1', '342', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26033', '管理员', '2015-12-02 19:53:48.772', '管理员', '2015-12-02 19:53:48.772', '1', '364', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26034', '管理员', '2015-12-02 19:53:48.775', '管理员', '2015-12-02 19:53:48.775', '1', '365', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26035', '管理员', '2015-12-02 19:53:48.778', '管理员', '2015-12-02 19:53:48.778', '1', '366', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26036', '管理员', '2015-12-02 19:53:48.781', '管理员', '2015-12-02 19:53:48.781', '1', '367', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26037', '管理员', '2015-12-02 19:53:48.784', '管理员', '2015-12-02 19:53:48.784', '1', '343', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26038', '管理员', '2015-12-02 19:53:48.787', '管理员', '2015-12-02 19:53:48.787', '1', '368', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26039', '管理员', '2015-12-02 19:53:48.79', '管理员', '2015-12-02 19:53:48.79', '1', '369', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26040', '管理员', '2015-12-02 19:53:48.793', '管理员', '2015-12-02 19:53:48.793', '1', '370', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26041', '管理员', '2015-12-02 19:53:48.796', '管理员', '2015-12-02 19:53:48.796', '1', '371', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26042', '管理员', '2015-12-02 19:53:48.799', '管理员', '2015-12-02 19:53:48.799', '1', '340', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26043', '管理员', '2015-12-02 19:53:48.802', '管理员', '2015-12-02 19:53:48.802', '1', '345', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26044', '管理员', '2015-12-02 19:53:48.805', '管理员', '2015-12-02 19:53:48.805', '1', '372', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26045', '管理员', '2015-12-02 19:53:48.807', '管理员', '2015-12-02 19:53:48.807', '1', '373', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26046', '管理员', '2015-12-02 19:53:48.81', '管理员', '2015-12-02 19:53:48.81', '1', '374', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26047', '管理员', '2015-12-02 19:53:48.813', '管理员', '2015-12-02 19:53:48.813', '1', '375', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26048', '管理员', '2015-12-02 19:53:48.815', '管理员', '2015-12-02 19:53:48.815', '1', '344', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26049', '管理员', '2015-12-02 19:53:48.819', '管理员', '2015-12-02 19:53:48.819', '1', '380', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26050', '管理员', '2015-12-02 19:53:48.822', '管理员', '2015-12-02 19:53:48.822', '1', '381', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26051', '管理员', '2015-12-02 19:53:48.825', '管理员', '2015-12-02 19:53:48.825', '1', '382', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26052', '管理员', '2015-12-02 19:53:48.828', '管理员', '2015-12-02 19:53:48.828', '1', '383', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26053', '管理员', '2015-12-02 19:53:48.831', '管理员', '2015-12-02 19:53:48.831', '1', '347', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26054', '管理员', '2015-12-02 19:53:48.834', '管理员', '2015-12-02 19:53:48.834', '1', '384', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26055', '管理员', '2015-12-02 19:53:48.837', '管理员', '2015-12-02 19:53:48.837', '1', '385', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26056', '管理员', '2015-12-02 19:53:48.84', '管理员', '2015-12-02 19:53:48.84', '1', '386', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26057', '管理员', '2015-12-02 19:53:48.844', '管理员', '2015-12-02 19:53:48.844', '1', '387', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26058', '管理员', '2015-12-02 19:53:48.846', '管理员', '2015-12-02 19:53:48.846', '1', '341', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26059', '管理员', '2015-12-02 19:53:48.85', '管理员', '2015-12-02 19:53:48.85', '1', '349', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26060', '管理员', '2015-12-02 19:53:48.853', '管理员', '2015-12-02 19:53:48.853', '1', '392', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26061', '管理员', '2015-12-02 19:53:48.856', '管理员', '2015-12-02 19:53:48.856', '1', '393', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26062', '管理员', '2015-12-02 19:53:48.861', '管理员', '2015-12-02 19:53:48.861', '1', '394', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26063', '管理员', '2015-12-02 19:53:48.865', '管理员', '2015-12-02 19:53:48.865', '1', '395', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26064', '管理员', '2015-12-02 19:53:48.867', '管理员', '2015-12-02 19:53:48.867', '1', '59', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26065', '管理员', '2015-12-02 19:53:48.87', '管理员', '2015-12-02 19:53:48.87', '1', '348', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26066', '管理员', '2015-12-02 19:53:48.874', '管理员', '2015-12-02 19:53:48.874', '1', '388', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26067', '管理员', '2015-12-02 19:53:48.876', '管理员', '2015-12-02 19:53:48.876', '1', '389', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26068', '管理员', '2015-12-02 19:53:48.879', '管理员', '2015-12-02 19:53:48.879', '1', '390', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26069', '管理员', '2015-12-02 19:53:48.882', '管理员', '2015-12-02 19:53:48.882', '1', '391', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26070', '管理员', '2015-12-02 19:53:48.885', '管理员', '2015-12-02 19:53:48.885', '1', '346', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26071', '管理员', '2015-12-02 19:53:48.888', '管理员', '2015-12-02 19:53:48.888', '1', '376', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26072', '管理员', '2015-12-02 19:53:48.891', '管理员', '2015-12-02 19:53:48.891', '1', '377', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26073', '管理员', '2015-12-02 19:53:48.894', '管理员', '2015-12-02 19:53:48.894', '1', '378', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26074', '管理员', '2015-12-02 19:53:48.897', '管理员', '2015-12-02 19:53:48.897', '1', '379', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26075', '管理员', '2015-12-02 19:53:48.9', '管理员', '2015-12-02 19:53:48.9', '1', '350', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26076', '管理员', '2015-12-02 19:53:48.903', '管理员', '2015-12-02 19:53:48.903', '1', '396', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26077', '管理员', '2015-12-02 19:53:48.906', '管理员', '2015-12-02 19:53:48.906', '1', '397', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26078', '管理员', '2015-12-02 19:53:48.909', '管理员', '2015-12-02 19:53:48.909', '1', '398', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26079', '管理员', '2015-12-02 19:53:48.912', '管理员', '2015-12-02 19:53:48.912', '1', '399', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26080', '管理员', '2015-12-02 19:53:48.914', '管理员', '2015-12-02 19:53:48.914', '1', '351', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26081', '管理员', '2015-12-02 19:53:48.917', '管理员', '2015-12-02 19:53:48.917', '1', '400', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26082', '管理员', '2015-12-02 19:53:48.921', '管理员', '2015-12-02 19:53:48.921', '1', '401', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26083', '管理员', '2015-12-02 19:53:48.924', '管理员', '2015-12-02 19:53:48.924', '1', '402', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26084', '管理员', '2015-12-02 19:53:48.93', '管理员', '2015-12-02 19:53:48.93', '1', '403', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26085', '管理员', '2015-12-02 19:53:48.937', '管理员', '2015-12-02 19:53:48.937', '1', '61', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26086', '管理员', '2015-12-02 19:53:48.94', '管理员', '2015-12-02 19:53:48.94', '1', '356', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26087', '管理员', '2015-12-02 19:53:48.944', '管理员', '2015-12-02 19:53:48.944', '1', '357', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26088', '管理员', '2015-12-02 19:53:48.946', '管理员', '2015-12-02 19:53:48.946', '1', '358', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26089', '管理员', '2015-12-02 19:53:48.949', '管理员', '2015-12-02 19:53:48.949', '1', '359', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26090', '管理员', '2015-12-02 19:53:48.952', '管理员', '2015-12-02 19:53:48.952', '1', '60', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26091', '管理员', '2015-12-02 19:53:48.955', '管理员', '2015-12-02 19:53:48.955', '1', '352', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26092', '管理员', '2015-12-02 19:53:48.96', '管理员', '2015-12-02 19:53:48.96', '1', '353', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26093', '管理员', '2015-12-02 19:53:48.963', '管理员', '2015-12-02 19:53:48.963', '1', '355', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26094', '管理员', '2015-12-02 19:53:48.966', '管理员', '2015-12-02 19:53:48.966', '1', '354', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26095', '管理员', '2015-12-02 19:53:48.97', '管理员', '2015-12-02 19:53:48.97', '1', '62', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26096', '管理员', '2015-12-02 19:53:48.972', '管理员', '2015-12-02 19:53:48.972', '1', '360', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26097', '管理员', '2015-12-02 19:53:48.976', '管理员', '2015-12-02 19:53:48.976', '1', '361', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26098', '管理员', '2015-12-02 19:53:48.981', '管理员', '2015-12-02 19:53:48.981', '1', '362', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26099', '管理员', '2015-12-02 19:53:48.987', '管理员', '2015-12-02 19:53:48.987', '1', '363', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26100', '管理员', '2015-12-02 19:53:48.993', '管理员', '2015-12-02 19:53:48.993', '1', '22810', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26101', '管理员', '2015-12-02 19:53:48.996', '管理员', '2015-12-02 19:53:48.996', '1', '22811', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26102', '管理员', '2015-12-02 19:53:49', '管理员', '2015-12-02 19:53:49', '1', '22812', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26103', '管理员', '2015-12-02 19:53:49.003', '管理员', '2015-12-02 19:53:49.003', '1', '22814', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26104', '管理员', '2015-12-02 19:53:49.007', '管理员', '2015-12-02 19:53:49.007', '1', '22813', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26105', '管理员', '2015-12-02 19:53:49.01', '管理员', '2015-12-02 19:53:49.01', '1', '24710', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26106', '管理员', '2015-12-02 19:53:49.014', '管理员', '2015-12-02 19:53:49.014', '1', '24711', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26107', '管理员', '2015-12-02 19:53:49.018', '管理员', '2015-12-02 19:53:49.018', '1', '25810', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26108', '管理员', '2015-12-02 19:53:49.026', '管理员', '2015-12-02 19:53:49.026', '1', '13713', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26109', '管理员', '2015-12-02 19:53:49.031', '管理员', '2015-12-02 19:53:49.031', '1', '278', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26210', '管理员', '2015-12-02 19:53:49.038', '管理员', '2015-12-02 19:53:49.038', '1', '275', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26211', '管理员', '2015-12-02 19:53:49.046', '管理员', '2015-12-02 19:53:49.046', '1', '277', '1212');
INSERT INTO "public"."sys_role_function" VALUES ('26212', '管理员', '2015-12-02 19:53:49.049', '管理员', '2015-12-02 19:53:49.049', '1', '276', '1212');

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_role_permission";
CREATE TABLE "public"."sys_role_permission" (
"role_id" int8 NOT NULL,
"permission_id" int8 NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role_user
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_role_user";
CREATE TABLE "public"."sys_role_user" (
"id" int8 NOT NULL,
"createby" varchar(255) COLLATE "default",
"creationdate" timestamp(6),
"updateby" varchar(255) COLLATE "default",
"updatedate" timestamp(6),
"version_" int8,
"roleid" int8 NOT NULL,
"userid" int8 NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of sys_role_user
-- ----------------------------
INSERT INTO "public"."sys_role_user" VALUES ('107', '管理员', '2015-11-16 16:25:41.051', '管理员', '2015-11-16 16:25:41.051', '0', '1212', '5601');
INSERT INTO "public"."sys_role_user" VALUES ('108', '管理员', '2015-11-16 16:25:41.066', '管理员', '2015-11-16 16:25:41.066', '0', '1212', '7001');
INSERT INTO "public"."sys_role_user" VALUES ('109', '管理员', '2015-11-16 16:25:41.078', '管理员', '2015-11-16 16:25:41.078', '0', '1212', '11501');
INSERT INTO "public"."sys_role_user" VALUES ('1806', '管理员', '2015-11-17 01:52:55.053', '管理员', '2015-11-17 01:52:55.053', '0', '1673', '26');
INSERT INTO "public"."sys_role_user" VALUES ('1807', '管理员', '2015-11-17 01:52:55.057', '管理员', '2015-11-17 01:52:55.057', '0', '1673', '28');
INSERT INTO "public"."sys_role_user" VALUES ('6306', '管理员', '2015-07-29 10:31:41', '管理员', '2015-07-29 10:31:41', '1', '1213', '110');
INSERT INTO "public"."sys_role_user" VALUES ('6307', '管理员', '2015-07-29 10:31:41', '管理员', '2015-07-29 10:31:41', '1', '1213', '111');
INSERT INTO "public"."sys_role_user" VALUES ('13101', '管理员2', '2015-08-12 14:50:54', '管理员2', '2015-08-12 14:50:54', '1', '4901', '11501');
INSERT INTO "public"."sys_role_user" VALUES ('14201', '管理员2', '2015-08-13 10:42:49', '管理员2', '2015-08-13 10:42:49', '1', '14001', '14101');
INSERT INTO "public"."sys_role_user" VALUES ('14202', '管理员2', '2015-08-13 10:43:05', '管理员2', '2015-08-13 10:43:05', '1', '14002', '14102');
INSERT INTO "public"."sys_role_user" VALUES ('19310', '管理员', '2015-11-23 09:55:54.395', '管理员', '2015-11-23 09:55:54.395', '1', '1674', '28');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_user";
CREATE TABLE "public"."sys_user" (
"id" int8 NOT NULL,
"createby" varchar(255) COLLATE "default",
"creationdate" timestamp(6),
"updateby" varchar(255) COLLATE "default",
"updatedate" timestamp(6),
"version_" int8,
"available" int4 NOT NULL,
"email" varchar(255) COLLATE "default",
"is_ent_user" int4 NOT NULL,
"jgdm" varchar(255) COLLATE "default",
"logindate" timestamp(6),
"loginip" varchar(255) COLLATE "default",
"loginname" varchar(255) COLLATE "default",
"mobile" varchar(255) COLLATE "default",
"name" varchar(255) COLLATE "default",
"password" varchar(255) COLLATE "default",
"phone" varchar(255) COLLATE "default",
"qyid" varchar(255) COLLATE "default",
"relateid" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO "public"."sys_user" VALUES ('6', '管理员', '2015-10-27 10:21:39.397', '管理员', '2015-10-27 10:21:39.397', '0', '1', 'kk@132.com', '0', null, '2015-11-09 17:03:01.192', '172.16.5.250', '000', '12322224444', 'gs', 'ICy5YqxZB1uWSwcVLSNLcA==', '', '', null);
INSERT INTO "public"."sys_user" VALUES ('7', '管理员', '2015-10-27 10:21:50.707', '管理员', '2015-10-27 10:21:50.707', '0', '1', 'kk@132.com', '0', null, null, null, '001', '12322224444', 'ds', 'ICy5YqxZB1uWSwcVLSNLcA==', '', '', null);
INSERT INTO "public"."sys_user" VALUES ('25', '管理员', '2015-11-16 08:41:37.597', '管理员', '2015-11-16 08:41:37.597', '0', '1', 'gaoguannan@rexen.com.cn', '0', null, null, null, 'gaoguannan', '13911023979', '高冠男', 'ICy5YqxZB1uWSwcVLSNLcA==', '999', '', null);
INSERT INTO "public"."sys_user" VALUES ('26', '管理员', '2015-11-16 08:43:23.692', '管理员', '2015-11-16 08:43:23.692', '8', '1', 'xufeng@rexen.com.cn', '0', null, '2015-12-03 15:02:36.212', '0:0:0:0:0:0:0:1', 'xufeng', '13804324080', '徐峰', 'ICy5YqxZB1uWSwcVLSNLcA==', '966', '', null);
INSERT INTO "public"."sys_user" VALUES ('27', '管理员', '2015-11-16 08:44:41.496', '管理员', '2015-11-16 08:44:41.496', '0', '1', 'donghongliang@rexen.com.cn', '0', null, null, null, 'donhongliang', '17790005688', '董洪良', 'ICy5YqxZB1uWSwcVLSNLcA==', '935', '', null);
INSERT INTO "public"."sys_user" VALUES ('28', '管理员', '2015-11-16 08:45:53.704', '管理员', '2015-11-16 08:45:53.704', '2', '1', 'sunlingfeng@rexen.com.cn', '0', null, '2015-11-23 11:24:46.012', '0:0:0:0:0:0:0:1', 'sunlingfeng', '15643117897', '孙凌峰', 'ICy5YqxZB1uWSwcVLSNLcA==', '929', '', null);
INSERT INTO "public"."sys_user" VALUES ('29', '管理员', '2015-11-16 08:47:24.807', '管理员', '2015-11-16 08:47:24.807', '0', '1', 'zangyanming@rexen.com.cn', '0', null, null, null, 'zangyanming', '13944197185', '臧彦明', 'ICy5YqxZB1uWSwcVLSNLcA==', '917', '', null);
INSERT INTO "public"."sys_user" VALUES ('30', '管理员', '2015-11-16 08:48:23.901', '管理员', '2015-11-16 08:48:23.901', '0', '1', 'fuqiang@rexen.com.cn', '0', null, '2015-11-17 02:13:23.541', '0:0:0:0:0:0:0:1', 'fuqiang', '18843165183', '付强', 'ICy5YqxZB1uWSwcVLSNLcA==', '', '', null);
INSERT INTO "public"."sys_user" VALUES ('31', '管理员', '2015-11-16 08:49:33.551', '管理员', '2015-11-16 08:49:33.551', '0', '1', 'liangxuesong@rexen.com.cn', '0', null, null, null, 'liangxuesong', '13944955078', '梁雪松', 'ICy5YqxZB1uWSwcVLSNLcA==', '', '', null);
INSERT INTO "public"."sys_user" VALUES ('32', '管理员', '2015-11-16 08:51:45.803', '管理员', '2015-11-16 08:51:45.803', '0', '1', 'guanxuejun@rexen.com.cn', '0', null, null, null, 'guanxuejun', '13944899307', '关雪君', 'ICy5YqxZB1uWSwcVLSNLcA==', '', '', null);
INSERT INTO "public"."sys_user" VALUES ('33', '管理员', '2015-11-16 08:52:34.666', '管理员', '2015-11-16 08:52:34.666', '0', '1', 'liuyu@rexen.com.cn', '0', null, null, null, 'liuyu', '13488826660', '刘宇', 'ICy5YqxZB1uWSwcVLSNLcA==', '', '', null);
INSERT INTO "public"."sys_user" VALUES ('34', '管理员', '2015-11-16 08:53:28.103', '管理员', '2015-11-16 08:53:28.103', '0', '1', 'chenyanxu@rexen.com.cn', '0', null, null, null, 'chenyanxu', '15584288961', '陈岩旭', 'ICy5YqxZB1uWSwcVLSNLcA==', '', '', null);
INSERT INTO "public"."sys_user" VALUES ('35', '管理员', '2015-11-16 08:54:06.668', '管理员', '2015-11-16 08:54:06.668', '0', '1', 'sunyu@rexen.com.cn', '0', null, null, null, 'sunyu', '13404789892', '孙雨', 'ICy5YqxZB1uWSwcVLSNLcA==', '', '', null);
INSERT INTO "public"."sys_user" VALUES ('36', '管理员', '2015-11-16 08:57:54.82', '管理员', '2015-11-16 08:57:54.82', '0', '1', 'caoning@rexen.com.cn', '0', null, null, null, 'caoning', '13578752760', '曹宁', 'ICy5YqxZB1uWSwcVLSNLcA==', '', '', null);
INSERT INTO "public"."sys_user" VALUES ('37', '管理员', '2015-11-16 08:59:45.152', '管理员', '2015-11-16 08:59:45.152', '0', '1', 'wangchunyang@rexen.com.cn', '0', null, null, null, 'wangchunyang', '15004309823', '王春杨', 'ICy5YqxZB1uWSwcVLSNLcA==', '', '', null);
INSERT INTO "public"."sys_user" VALUES ('38', '管理员', '2015-11-16 09:00:40.369', '管理员', '2015-11-16 09:00:40.369', '0', '1', 'lichunmiao@rexen.com.cn', '0', null, null, null, 'lichunmiao', '18946727122', '李春苗', 'ICy5YqxZB1uWSwcVLSNLcA==', '938', '', null);
INSERT INTO "public"."sys_user" VALUES ('39', '管理员', '2015-11-16 09:01:48.109', '管理员', '2015-11-16 09:01:48.109', '0', '1', 'zhoujing@rexen.com.cn', '0', null, null, null, 'zhoujing', '18844591148', '周晶', 'ICy5YqxZB1uWSwcVLSNLcA==', '', '', null);
INSERT INTO "public"."sys_user" VALUES ('40', '管理员', '2015-11-16 09:03:05.417', '管理员', '2015-11-16 09:03:05.417', '0', '1', 'wujing@rexen.com.cn', '0', null, null, null, 'wujing', '17804304082', '吴静', 'ICy5YqxZB1uWSwcVLSNLcA==', '', '', null);
INSERT INTO "public"."sys_user" VALUES ('41', '管理员', '2015-11-16 09:10:27.097', '管理员', '2015-11-16 09:10:27.097', '0', '1', 'liuyinglei@rexen.com.cn', '0', null, null, null, 'liuyinglei', '18043125222', '刘英雷', 'ICy5YqxZB1uWSwcVLSNLcA==', '922', '', null);
INSERT INTO "public"."sys_user" VALUES ('42', '管理员', '2015-11-16 09:11:14.057', '管理员', '2015-11-16 09:11:14.057', '0', '1', 'zhaochuang@rexen.com.cn', '0', null, null, null, 'zhaochuang', '18186886339', '赵创', 'ICy5YqxZB1uWSwcVLSNLcA==', '909', '', null);
INSERT INTO "public"."sys_user" VALUES ('43', '管理员', '2015-11-16 09:12:02.547', '管理员', '2015-11-16 09:12:02.547', '0', '1', 'lishanshan@rexen.com.cn', '0', null, null, null, 'lishanshan', '13174419059', '李珊珊', 'ICy5YqxZB1uWSwcVLSNLcA==', '905', '', null);
INSERT INTO "public"."sys_user" VALUES ('44', '管理员', '2015-11-16 09:13:00.081', '管理员', '2015-11-16 09:13:00.081', '0', '1', 'wangguitao@rexen.com.cn', '0', null, null, null, 'wangguitao', '13804466063', '王贵涛', 'ICy5YqxZB1uWSwcVLSNLcA==', '911', '', null);
INSERT INTO "public"."sys_user" VALUES ('45', '管理员', '2015-11-16 09:14:51.95', '管理员', '2015-11-16 09:14:51.95', '0', '1', 'chenxiaokui@rexen.com.cn', '0', null, null, null, 'chenxiaokui', '18104313279', '陈晓魁', 'ICy5YqxZB1uWSwcVLSNLcA==', '', '', null);
INSERT INTO "public"."sys_user" VALUES ('46', '管理员', '2015-11-16 09:15:38.343', '管理员', '2015-11-16 09:15:38.343', '0', '1', 'honghao@rexen.com.cn', '0', null, null, null, 'honghao', '18843005665', '洪浩', 'ICy5YqxZB1uWSwcVLSNLcA==', '', '', null);
INSERT INTO "public"."sys_user" VALUES ('47', '管理员', '2015-11-16 09:16:17.16', '管理员', '2015-11-16 09:16:17.16', '0', '1', 'yangzhuo@rexen.com.cn', '0', null, null, null, 'yangzhuo', '13944909239', '杨卓', 'ICy5YqxZB1uWSwcVLSNLcA==', '', '', null);
INSERT INTO "public"."sys_user" VALUES ('48', '管理员', '2015-11-16 09:16:53.947', '管理员', '2015-11-16 09:16:53.947', '0', '1', 'sunwei@rexen.com.cn', '0', null, null, null, 'sunwei', '15948756223', '孙伟', 'ICy5YqxZB1uWSwcVLSNLcA==', '', '', null);
INSERT INTO "public"."sys_user" VALUES ('49', '管理员', '2015-11-16 09:17:28.378', '管理员', '2015-11-16 09:17:28.378', '0', '1', 'wangqi@rexen.com.cn', '0', null, null, null, 'wangqi', '13596148855', '王琪', 'ICy5YqxZB1uWSwcVLSNLcA==', '', '', null);
INSERT INTO "public"."sys_user" VALUES ('50', '管理员', '2015-11-16 09:18:00.968', '管理员', '2015-11-16 09:18:00.968', '0', '1', 'xuyin@rexen.com.cn', '0', null, null, null, 'xuyin', '18943699395', '徐银', 'ICy5YqxZB1uWSwcVLSNLcA==', '', '', null);
INSERT INTO "public"."sys_user" VALUES ('51', '管理员', '2015-11-16 09:18:42.978', '管理员', '2015-11-16 09:18:42.978', '0', '1', 'liyixin@rexen.com.cn', '0', null, null, null, 'liyixin', '18626664311', '李易昕', 'ICy5YqxZB1uWSwcVLSNLcA==', '', '', null);
INSERT INTO "public"."sys_user" VALUES ('52', '管理员', '2015-11-16 09:19:29.494', '管理员', '2015-11-16 09:19:29.494', '0', '1', 'zhaohao@rexen.com.cn', '0', null, null, null, 'zhaohao', '18946723663', '赵昊', 'ICy5YqxZB1uWSwcVLSNLcA==', '916', '', null);
INSERT INTO "public"."sys_user" VALUES ('53', '管理员', '2015-11-16 09:20:21.48', '管理员', '2015-11-16 09:20:21.48', '0', '1', 'zhouhaiyang@rexen.com.cn', '0', null, null, null, 'zhouhaiyang', '17704306226', '周海洋', 'ICy5YqxZB1uWSwcVLSNLcA==', '963', '', null);
INSERT INTO "public"."sys_user" VALUES ('54', '管理员', '2015-11-16 09:20:59.886', '管理员', '2015-11-16 09:20:59.886', '0', '1', 'baichensheng@rexen.com.cn', '0', null, null, null, 'baichensheng', '15590554599', '白晨生', 'ICy5YqxZB1uWSwcVLSNLcA==', '', '', null);
INSERT INTO "public"."sys_user" VALUES ('55', '管理员', '2015-11-16 09:23:12.49', '管理员', '2015-11-16 09:23:12.49', '0', '1', 'ligang@rexen.com.cn', '0', null, null, null, 'ligang', '18543126703', '李岗', 'ICy5YqxZB1uWSwcVLSNLcA==', '', '', null);
INSERT INTO "public"."sys_user" VALUES ('56', '管理员', '2015-11-16 09:24:14.595', '管理员', '2015-11-16 09:24:14.595', '0', '1', 'hanxinye@rexen.com.cn', '0', null, null, null, 'hanxinye', '18686657746', '韩馨晔', 'ICy5YqxZB1uWSwcVLSNLcA==', '942', '', null);
INSERT INTO "public"."sys_user" VALUES ('58', '管理员', '2015-11-16 09:27:26.562', '管理员', '2015-11-16 09:27:26.562', '0', '1', 'jilongxue@rexen.com.cn', '0', null, null, null, 'jilongxue', '15104467453', '纪龙雪', 'ICy5YqxZB1uWSwcVLSNLcA==', '', '', null);
INSERT INTO "public"."sys_user" VALUES ('59', '管理员', '2015-11-16 09:28:19.243', '管理员', '2015-11-16 09:28:19.243', '0', '1', 'sunshengli@rexen.com.cn', '0', null, null, null, 'sunshengli', '18243049928', '孙胜利', 'ICy5YqxZB1uWSwcVLSNLcA==', '', '', null);
INSERT INTO "public"."sys_user" VALUES ('60', '管理员', '2015-11-16 09:29:04.619', '管理员', '2015-11-16 09:29:04.619', '0', '1', 'sunkuo@rexen.com.cn', '0', null, null, null, 'sunkuo', '13664401109', '孙阔', 'ICy5YqxZB1uWSwcVLSNLcA==', '913', '', null);
INSERT INTO "public"."sys_user" VALUES ('61', '管理员', '2015-11-16 09:30:38.2', '管理员', '2015-11-16 09:30:38.2', '0', '1', 'liulin@rexen.com.cn', '0', null, null, null, 'liulin', '15500006740', '刘琳', 'ICy5YqxZB1uWSwcVLSNLcA==', '', '', null);
INSERT INTO "public"."sys_user" VALUES ('62', '管理员', '2015-11-16 09:31:35.569', '管理员', '2015-11-16 09:31:35.569', '0', '1', 'tianyu@rexen.com.cn', '0', null, null, null, 'tianyu', '13194371348', '田雨', 'ICy5YqxZB1uWSwcVLSNLcA==', '', '', null);
INSERT INTO "public"."sys_user" VALUES ('63', '管理员', '2015-11-16 09:32:18.678', '管理员', '2015-11-16 09:32:18.678', '0', '1', 'zhangbo@rexen.com.cn', '0', null, null, null, 'zhangbo', '18843111891', '张博', 'ICy5YqxZB1uWSwcVLSNLcA==', '', '', null);
INSERT INTO "public"."sys_user" VALUES ('64', '管理员', '2015-11-16 09:33:02.751', '管理员', '2015-11-16 09:33:02.751', '0', '1', 'zhangjinhui@rexen.com.cn', '0', null, null, null, 'zhangjinhui', '13074355825', '张金辉', 'ICy5YqxZB1uWSwcVLSNLcA==', '', '', null);
INSERT INTO "public"."sys_user" VALUES ('65', '管理员', '2015-11-16 09:34:02.527', '管理员', '2015-11-16 09:34:02.527', '0', '1', 'yuxiaohong@rexen.com.cn', '0', null, null, null, 'yuxiaohong', '18186883913', '于晓红', 'ICy5YqxZB1uWSwcVLSNLcA==', '', '', null);
INSERT INTO "public"."sys_user" VALUES ('66', '管理员', '2015-11-16 09:34:38.48', '管理员', '2015-11-16 09:34:38.48', '0', '1', 'jialei@rexen.com.cn', '0', null, null, null, 'jialei', '15543011732', '贾磊', 'ICy5YqxZB1uWSwcVLSNLcA==', '', '', null);
INSERT INTO "public"."sys_user" VALUES ('67', '管理员', '2015-11-16 09:35:20.468', '管理员', '2015-11-16 09:35:20.468', '0', '1', 'daishumin@rexen.com.cn', '0', null, null, null, 'daishumin', '13500818757', '代树民', 'ICy5YqxZB1uWSwcVLSNLcA==', '977', '', null);
INSERT INTO "public"."sys_user" VALUES ('68', '管理员', '2015-11-16 09:36:15.827', '管理员', '2015-11-16 09:36:15.827', '0', '1', 'cuiweiyan@rexen.com.cn', '0', null, null, null, 'cuiweiyan', '13578721900', '崔巍岩', 'ICy5YqxZB1uWSwcVLSNLcA==', '962', '', null);
INSERT INTO "public"."sys_user" VALUES ('69', '管理员', '2015-11-16 09:37:01.52', '管理员', '2015-11-16 09:37:01.52', '0', '1', 'yanbo@rexen.com.cn', '0', null, null, null, 'yanbo', '18943676928', '闫博', 'ICy5YqxZB1uWSwcVLSNLcA==', '948', '', null);
INSERT INTO "public"."sys_user" VALUES ('70', '管理员', '2015-11-16 09:38:25.885', '管理员', '2015-11-16 09:38:25.885', '0', '1', 'zhangyubo@rexen.com.cn', '0', null, null, null, 'zhangyubo', '13943175287', '张宇博', 'ICy5YqxZB1uWSwcVLSNLcA==', '953', '', null);
INSERT INTO "public"."sys_user" VALUES ('71', '管理员', '2015-11-16 09:39:15.086', '管理员', '2015-11-16 09:39:15.086', '0', '1', 'wanghongzhi@rexen.com.cn', '0', null, null, null, 'wanghongzhi', '13331640524', '王洪智', 'ICy5YqxZB1uWSwcVLSNLcA==', '', '', null);
INSERT INTO "public"."sys_user" VALUES ('72', '管理员', '2015-11-16 09:40:16.058', '管理员', '2015-11-16 09:40:16.058', '0', '1', 'zhaolin@rexen.com.cn', '0', null, null, null, 'zhaolin', '18946502306', '赵琳', 'ICy5YqxZB1uWSwcVLSNLcA==', '', '', null);
INSERT INTO "public"."sys_user" VALUES ('73', '管理员', '2015-11-16 09:40:55.257', '管理员', '2015-11-16 09:40:55.257', '0', '1', 'zhouqing@rexen.com.cn', '0', null, null, null, 'zhouqing', '13756881967', '周庆', 'ICy5YqxZB1uWSwcVLSNLcA==', '', '', null);
INSERT INTO "public"."sys_user" VALUES ('74', '管理员', '2015-11-16 09:41:29.945', '管理员', '2015-11-16 09:41:29.945', '0', '1', 'guotao@rexen.com.cn', '0', null, null, null, 'guotao', '15044304411', '郭涛', 'ICy5YqxZB1uWSwcVLSNLcA==', '', '', null);
INSERT INTO "public"."sys_user" VALUES ('75', '管理员', '2015-11-16 09:42:25.867', '管理员', '2015-11-16 09:42:25.867', '0', '1', 'zhongmingyi@rexen.com.cn', '0', null, null, null, 'zhongmingyi', '15662133233', '钟明艺', 'ICy5YqxZB1uWSwcVLSNLcA==', '', '', null);
INSERT INTO "public"."sys_user" VALUES ('76', '管理员', '2015-11-16 09:43:17.878', '管理员', '2015-11-16 09:43:17.878', '0', '1', 'xiaona@rexen.com.cn', '0', null, null, null, 'xiaona', '15568846097', '肖娜', 'ICy5YqxZB1uWSwcVLSNLcA==', '', '', null);
INSERT INTO "public"."sys_user" VALUES ('77', '管理员', '2015-11-16 09:44:14.197', '管理员', '2015-11-16 09:44:14.197', '0', '1', 'tianfuchen@rexen.com.cn', '0', null, null, null, 'tianfuchen', '15943034227', '田福臣', 'ICy5YqxZB1uWSwcVLSNLcA==', '', '', null);
INSERT INTO "public"."sys_user" VALUES ('78', '管理员', '2015-11-16 09:46:24.371', '管理员', '2015-11-16 09:46:24.371', '0', '1', 'wangfazhan@rexen.com.cn', '0', null, null, null, 'wangfazhan', '18643144340', '王发展', 'ICy5YqxZB1uWSwcVLSNLcA==', '940', '', null);
INSERT INTO "public"."sys_user" VALUES ('79', '管理员', '2015-11-16 12:59:11.507', '管理员', '2015-11-16 12:59:11.507', '0', '1', 'wangjun@rexen.com.cn', '0', null, null, null, 'wangjun', '13578880755', '王君', 'ICy5YqxZB1uWSwcVLSNLcA==', '', '', null);
INSERT INTO "public"."sys_user" VALUES ('80', '管理员', '2015-11-16 12:59:53.829', '管理员', '2015-11-16 12:59:53.829', '0', '1', 'wangzhuo@rexen.com.cn', '0', null, null, null, 'wangzhuo', '15143013642', '王卓', 'ICy5YqxZB1uWSwcVLSNLcA==', '', '', null);
INSERT INTO "public"."sys_user" VALUES ('81', '管理员', '2015-11-16 13:01:06.25', '管理员', '2015-11-16 13:01:06.25', '1', '1', 'pengcheng@rexen.com.cn', '0', null, '2015-12-02 10:48:12.978', '0:0:0:0:0:0:0:1', 'pengcheng', '18643116777', '彭程', 'ICy5YqxZB1uWSwcVLSNLcA==', '988', '', null);
INSERT INTO "public"."sys_user" VALUES ('82', '管理员', '2015-11-16 13:01:55.527', '管理员', '2015-11-16 13:01:55.527', '0', '1', 'caolu@rexen.com.cn', '0', null, null, null, 'caolu', '18686635600', '曹璐', 'ICy5YqxZB1uWSwcVLSNLcA==', '', '', null);
INSERT INTO "public"."sys_user" VALUES ('83', '管理员', '2015-11-16 13:02:31.949', '管理员', '2015-11-16 13:02:31.949', '0', '1', 'yuna@rexen.com.cn', '0', null, null, null, 'yuna', '18626661499', '余娜', 'ICy5YqxZB1uWSwcVLSNLcA==', '', '', null);
INSERT INTO "public"."sys_user" VALUES ('84', '管理员', '2015-11-16 13:03:13.883', '管理员', '2015-11-16 13:03:13.883', '0', '1', 'lixin@rexen.com.cn', '0', null, null, null, 'lixin', '13944106671', '李鑫', 'ICy5YqxZB1uWSwcVLSNLcA==', '', '', null);
INSERT INTO "public"."sys_user" VALUES ('85', '管理员', '2015-11-16 13:04:06.556', '管理员', '2015-11-16 13:04:06.556', '0', '1', 'zukeyong@rexen.com.cn', '0', null, null, null, 'zukeyong', '18843012111', '祖克永', 'ICy5YqxZB1uWSwcVLSNLcA==', '', '', null);
INSERT INTO "public"."sys_user" VALUES ('86', '管理员', '2015-11-16 13:04:51.601', '管理员', '2015-11-16 13:04:51.601', '0', '1', 'chenglei@rexen.com.cn', '0', null, null, null, 'chenglei', '18502706607', '程磊', 'ICy5YqxZB1uWSwcVLSNLcA==', '', '', null);
INSERT INTO "public"."sys_user" VALUES ('87', '管理员', '2015-11-16 13:05:53.632', '管理员', '2015-11-16 13:05:53.632', '0', '1', 'wulijie@rexen.com.cn', '0', null, null, null, 'wulijie', '13804466057', '吴丽洁', 'ICy5YqxZB1uWSwcVLSNLcA==', '901', '', null);
INSERT INTO "public"."sys_user" VALUES ('88', '管理员', '2015-11-16 13:06:56.795', '管理员', '2015-11-16 13:06:56.795', '0', '1', 'junanyang@rexen.com.cn', '0', null, null, null, 'junanyang', '18744028767', '鞠南洋', 'ICy5YqxZB1uWSwcVLSNLcA==', '967', '', null);
INSERT INTO "public"."sys_user" VALUES ('89', '管理员', '2015-11-16 13:10:30.932', '管理员', '2015-11-16 13:10:30.932', '0', '1', 'mengwenwen@rexen.com.cn', '0', null, null, null, 'mengwenwen', '18604443512', '孟雯雯', 'ICy5YqxZB1uWSwcVLSNLcA==', '', '', null);
INSERT INTO "public"."sys_user" VALUES ('90', '管理员', '2015-11-16 13:11:31.023', '管理员', '2015-11-16 13:11:31.023', '0', '1', 'hanyang@rexen.com.cn', '0', null, null, null, 'hanyang', '18686424088', '韩阳', 'ICy5YqxZB1uWSwcVLSNLcA==', '', '', null);
INSERT INTO "public"."sys_user" VALUES ('91', '管理员', '2015-11-16 13:13:13.255', '管理员', '2015-11-16 13:13:13.255', '0', '1', 'zhanglihong@rexen.com.cn', '0', null, null, null, 'zhanglihong', '13904327682', '张丽红', 'ICy5YqxZB1uWSwcVLSNLcA==', '955', '', null);
INSERT INTO "public"."sys_user" VALUES ('92', '管理员', '2015-11-16 13:14:09.427', '管理员', '2015-11-16 13:14:09.427', '0', '1', 'fanying@rexen.com.cn', '0', null, null, null, 'fanying', '18143107507', '范颖', 'ICy5YqxZB1uWSwcVLSNLcA==', '959', '', null);
INSERT INTO "public"."sys_user" VALUES ('93', '管理员', '2015-11-16 13:14:53.652', '管理员', '2015-11-16 13:14:53.652', '0', '1', 'caodayun@rexen.com.cn', '0', null, null, null, 'caodayun', '18043150666', '曹大运', 'ICy5YqxZB1uWSwcVLSNLcA==', '', '', null);
INSERT INTO "public"."sys_user" VALUES ('94', '管理员', '2015-11-16 13:15:51.625', '管理员', '2015-11-16 13:15:51.625', '0', '1', 'xiaoli@rexen.com.cn', '0', null, null, null, 'xiaoli', '13804466028', '肖丽', 'ICy5YqxZB1uWSwcVLSNLcA==', '', '', null);
INSERT INTO "public"."sys_user" VALUES ('95', '管理员', '2015-11-16 13:17:09.7', '管理员', '2015-11-16 13:17:09.7', '0', '1', 'wangtianle@rexen.com.cn', '0', null, null, null, 'wangtianle', '18610968601', '王添乐', 'ICy5YqxZB1uWSwcVLSNLcA==', '950', '', null);
INSERT INTO "public"."sys_user" VALUES ('96', '管理员', '2015-11-16 13:17:56.057', '管理员', '2015-11-16 13:17:56.057', '0', '1', 'zhangchao@rexen.com.cn', '0', null, null, null, 'zhangchao', '13321407200', '张超', 'ICy5YqxZB1uWSwcVLSNLcA==', '969', '', null);
INSERT INTO "public"."sys_user" VALUES ('97', '管理员', '2015-11-16 13:18:40.218', '管理员', '2015-11-16 13:18:40.218', '0', '1', 'huwei@rexen.com.cn', '0', null, null, null, 'huwei', '13159604718', '胡帏', 'ICy5YqxZB1uWSwcVLSNLcA==', '931', '', null);
INSERT INTO "public"."sys_user" VALUES ('98', '管理员', '2015-11-16 13:19:51.931', '管理员', '2015-11-16 13:19:51.931', '0', '1', 'zhaoshuangyan@rexen.com.cn', '0', null, null, null, 'zhaoshuangyan', '18943169138', '赵双燕', 'ICy5YqxZB1uWSwcVLSNLcA==', '900', '', null);
INSERT INTO "public"."sys_user" VALUES ('99', '管理员', '2015-11-16 13:21:02.102', '管理员', '2015-11-16 13:21:02.102', '0', '1', 'liuboyang@rexen.com.cn', '0', null, null, null, 'liuboyang', '13944825622', '刘博洋', 'ICy5YqxZB1uWSwcVLSNLcA==', '', '', null);
INSERT INTO "public"."sys_user" VALUES ('100', '管理员', '2015-11-16 13:35:25.977', '管理员', '2015-11-16 13:35:25.977', '0', '1', 'Sunrui@rexen.com.cn', '0', null, null, null, 'sunrui', '18343118980', '孙瑞', 'ICy5YqxZB1uWSwcVLSNLcA==', '952', '', null);
INSERT INTO "public"."sys_user" VALUES ('101', '管理员', '2015-11-16 13:36:37.011', '管理员', '2015-11-16 13:36:37.011', '0', '1', 'wangwei@rexen.com.cn', '0', null, null, null, 'wangwei', '18610488242', '王威', 'ICy5YqxZB1uWSwcVLSNLcA==', '', '', null);
INSERT INTO "public"."sys_user" VALUES ('5601', '2', '2015-07-30 16:42:50', '管理员', '2015-07-30 16:42:50', '203', '1', '123', '0', null, '2015-12-03 14:58:21.823', '0:0:0:0:0:0:0:1', 'admin', '123', '管理员', 'ICy5YqxZB1uWSwcVLSNLcA==', '123', '', null);
INSERT INTO "public"."sys_user" VALUES ('7001', '管理员', '2015-08-18 10:06:33', '管理员2', '2015-08-18 10:06:33', '4', '1', 'zhangsan@163.com', '0', null, '2015-07-30 16:43:35', '0:0:0:0:0:0:0:1', 'zhangsan', '1305004812', '张三', 'ICy5YqxZB1uWSwcVLSNLcA==', '', '', null);
INSERT INTO "public"."sys_user" VALUES ('8301', null, '2015-07-30 16:00:12', '张三', '2015-07-30 16:00:12', '3', '1', 'lisi@163.com', '0', null, null, null, 'lisi', '13050041542', '李四', 'ICy5YqxZB1uWSwcVLSNLcA==', '', '', null);
INSERT INTO "public"."sys_user" VALUES ('11401', '管理员2', '2015-08-05 11:44:29', '管理员2', '2015-08-05 11:44:29', '1', '1', '123@123.com', '0', null, null, null, 'wangwu', '123456', '王五', 'ICy5YqxZB1uWSwcVLSNLcA==', '', '', null);
INSERT INTO "public"."sys_user" VALUES ('11501', '管理员2', '2015-08-18 10:00:28', '管理员2', '2015-08-18 10:00:28', '30', '1', '123', '0', null, '2015-11-22 20:43:14.827', '0:0:0:0:0:0:0:1', 'qwer', '123', 'qwer', 'ICy5YqxZB1uWSwcVLSNLcA==', '123', '', null);
INSERT INTO "public"."sys_user" VALUES ('14101', '管理员2', '2015-08-18 10:01:49', '管理员2', '2015-08-18 10:01:50', '29', '1', 'quanxiankongzhi@123.com', '0', null, '2015-08-17 14:01:32', '0:0:0:0:0:0:0:1', 'quanxiankongzhi', '123', '权限控制人', 'ICy5YqxZB1uWSwcVLSNLcA==', '', '', null);
INSERT INTO "public"."sys_user" VALUES ('14102', '管理员2', '2015-08-18 10:02:00', '管理员2', '2015-08-18 10:02:00', '5', '1', 'xitongchangliang@123.com', '0', null, '2015-08-13 16:42:45', '0:0:0:0:0:0:0:1', 'xitongchangliang', '123456', '系统常量管理人', 'ICy5YqxZB1uWSwcVLSNLcA==', '', '', null);
INSERT INTO "public"."sys_user" VALUES ('15601', '管理员2', '2015-08-18 10:01:08', '管理员2', '2015-08-18 10:01:08', '3', '1', 'jiami@123.com', '0', null, '2015-08-18 10:00:44', '0:0:0:0:0:0:0:1', 'jiami', '1308504852', '加密账户', 'ICy5YqxZB1uWSwcVLSNLcA==', '', '', null);

-- ----------------------------
-- Table structure for sys_user_rel
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_user_rel";
CREATE TABLE "public"."sys_user_rel" (
"id" int8 NOT NULL,
"createby" varchar(255) COLLATE "default",
"creationdate" timestamp(6),
"updateby" varchar(255) COLLATE "default",
"updatedate" timestamp(6),
"version_" int8,
"token" varchar(255) COLLATE "default",
"user_id" int8 NOT NULL,
"user_logo" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of sys_user_rel
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_user_role";
CREATE TABLE "public"."sys_user_role" (
"user_id" int8 NOT NULL,
"role_id" int8 NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------

-- ----------------------------
-- Table structure for sys_workgroup
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_workgroup";
CREATE TABLE "public"."sys_workgroup" (
"id" int8 NOT NULL,
"createby" varchar(255) COLLATE "default",
"creationdate" timestamp(6),
"updateby" varchar(255) COLLATE "default",
"updatedate" timestamp(6),
"version_" int8,
"name" varchar(255) COLLATE "default",
"remark" varchar(255) COLLATE "default",
"app" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of sys_workgroup
-- ----------------------------
INSERT INTO "public"."sys_workgroup" VALUES ('6201', '管理员', '2015-11-24 11:07:19.432', '管理员', '2015-11-24 11:07:19.436', '5', '超级管理员工作组', '超级管理员权限', '系统应用');
INSERT INTO "public"."sys_workgroup" VALUES ('7501', '管理员', '2015-11-24 11:07:34.008', '管理员', '2015-11-24 11:07:34.013', '4', '普通管理员工作组', '', '系统应用');
INSERT INTO "public"."sys_workgroup" VALUES ('20610', '管理员', '2015-11-24 11:06:22.369', '管理员', '2015-11-24 11:06:22.376', '3', '老总工作组', '具有全部协同办公系统权限', '协同办公');
INSERT INTO "public"."sys_workgroup" VALUES ('20611', '管理员', '2015-11-24 11:06:59.25', '管理员', '2015-11-24 11:06:59.255', '2', '研发体系工作组', '具有全部查看权限', '协同办公');
INSERT INTO "public"."sys_workgroup" VALUES ('20612', '管理员', '2015-11-24 11:06:52.092', '管理员', '2015-11-24 11:06:52.097', '2', '项目交付工作组', '具有交付查看权限', '协同办公');
INSERT INTO "public"."sys_workgroup" VALUES ('20613', '管理员', '2015-11-24 11:06:36.351', '管理员', '2015-11-24 11:06:36.355', '3', '售前项目工作组', '具有售前查看权限', '协同办公');
INSERT INTO "public"."sys_workgroup" VALUES ('20614', '管理员', '2015-11-24 11:06:44.509', '管理员', '2015-11-24 11:06:44.514', '2', '财务工作组', '具有财务查看权限', '协同办公');
INSERT INTO "public"."sys_workgroup" VALUES ('20615', '管理员', '2015-11-24 11:06:29.879', '管理员', '2015-11-24 11:06:29.884', '2', '合同管理工作组', '具有合同管理的管理权限', '协同办公');
INSERT INTO "public"."sys_workgroup" VALUES ('20616', '管理员', '2015-11-24 11:06:15.579', '管理员', '2015-11-24 11:06:15.59', '2', '通用功能工作组', '通用功能维护权限', '协同办公');

-- ----------------------------
-- Table structure for sys_workgroup_role
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_workgroup_role";
CREATE TABLE "public"."sys_workgroup_role" (
"id" int8 NOT NULL,
"createby" varchar(255) COLLATE "default",
"creationdate" timestamp(6),
"updateby" varchar(255) COLLATE "default",
"updatedate" timestamp(6),
"version_" int8,
"groupid" int8 NOT NULL,
"roleid" int8 NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of sys_workgroup_role
-- ----------------------------
INSERT INTO "public"."sys_workgroup_role" VALUES ('1785', '管理员', '2015-11-17 01:48:57.065', '管理员', '2015-11-17 01:48:57.065', '0', '1776', '1673');
INSERT INTO "public"."sys_workgroup_role" VALUES ('7704', null, '2015-07-29 17:06:47', null, '2015-07-29 17:06:47', '1', '1', '1');
INSERT INTO "public"."sys_workgroup_role" VALUES ('10301', '管理员', '2015-07-31 14:46:36', '管理员', '2015-07-31 14:46:36', '1', '7501', '1212');
INSERT INTO "public"."sys_workgroup_role" VALUES ('12401', 'qwer', '2015-08-11 15:20:49', 'qwer', '2015-08-11 15:20:49', '1', '6201', '1212');
INSERT INTO "public"."sys_workgroup_role" VALUES ('20715', '管理员', '2015-11-24 09:12:51.162', '管理员', '2015-11-24 09:12:51.162', '1', '20614', '19915');
INSERT INTO "public"."sys_workgroup_role" VALUES ('20716', '管理员', '2015-11-24 09:12:51.168', '管理员', '2015-11-24 09:12:51.168', '1', '20614', '1673');
INSERT INTO "public"."sys_workgroup_role" VALUES ('20717', '管理员', '2015-11-24 09:13:08.781', '管理员', '2015-11-24 09:13:08.781', '1', '20613', '19913');
INSERT INTO "public"."sys_workgroup_role" VALUES ('20718', '管理员', '2015-11-24 09:13:08.784', '管理员', '2015-11-24 09:13:08.784', '1', '20613', '1673');
INSERT INTO "public"."sys_workgroup_role" VALUES ('20719', '管理员', '2015-11-24 09:16:18.39', '管理员', '2015-11-24 09:16:18.39', '1', '20615', '19911');
INSERT INTO "public"."sys_workgroup_role" VALUES ('20720', '管理员', '2015-11-24 09:16:18.396', '管理员', '2015-11-24 09:16:18.396', '1', '20615', '1673');
INSERT INTO "public"."sys_workgroup_role" VALUES ('20721', '管理员', '2015-11-24 09:38:48.446', '管理员', '2015-11-24 09:38:48.446', '1', '20616', '1674');
INSERT INTO "public"."sys_workgroup_role" VALUES ('26110', '管理员', '2015-12-02 19:51:32.927', '管理员', '2015-12-02 19:51:32.927', '1', '20610', '19911');
INSERT INTO "public"."sys_workgroup_role" VALUES ('26111', '管理员', '2015-12-02 19:51:32.934', '管理员', '2015-12-02 19:51:32.934', '1', '20610', '19913');
INSERT INTO "public"."sys_workgroup_role" VALUES ('26112', '管理员', '2015-12-02 19:51:32.937', '管理员', '2015-12-02 19:51:32.937', '1', '20610', '19915');
INSERT INTO "public"."sys_workgroup_role" VALUES ('26113', '管理员', '2015-12-02 19:51:32.94', '管理员', '2015-12-02 19:51:32.94', '1', '20610', '1674');
INSERT INTO "public"."sys_workgroup_role" VALUES ('26114', '管理员', '2015-12-02 19:51:32.943', '管理员', '2015-12-02 19:51:32.943', '1', '20610', '24810');

-- ----------------------------
-- Table structure for sys_workgroup_user
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_workgroup_user";
CREATE TABLE "public"."sys_workgroup_user" (
"id" int8 NOT NULL,
"createby" varchar(255) COLLATE "default",
"creationdate" timestamp(6),
"updateby" varchar(255) COLLATE "default",
"updatedate" timestamp(6),
"version_" int8,
"groupid" int8 NOT NULL,
"userid" int8 NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of sys_workgroup_user
-- ----------------------------
INSERT INTO "public"."sys_workgroup_user" VALUES ('10001', '管理员', '2015-07-31 14:39:06', '管理员', '2015-07-31 14:39:06', '1', '7501', '9901');
INSERT INTO "public"."sys_workgroup_user" VALUES ('10004', '管理员', '2015-07-31 14:42:20', '管理员', '2015-07-31 14:42:20', '1', '6201', '7001');
INSERT INTO "public"."sys_workgroup_user" VALUES ('20810', '管理员', '2015-11-24 09:08:15.27', '管理员', '2015-11-24 09:08:15.27', '1', '20610', '26');
INSERT INTO "public"."sys_workgroup_user" VALUES ('20811', '管理员', '2015-11-24 09:08:15.28', '管理员', '2015-11-24 09:08:15.28', '1', '20610', '25');
INSERT INTO "public"."sys_workgroup_user" VALUES ('20812', '管理员', '2015-11-24 09:08:15.284', '管理员', '2015-11-24 09:08:15.284', '1', '20610', '41');
INSERT INTO "public"."sys_workgroup_user" VALUES ('20813', '管理员', '2015-11-24 09:08:15.287', '管理员', '2015-11-24 09:08:15.287', '1', '20610', '42');
INSERT INTO "public"."sys_workgroup_user" VALUES ('20814', '管理员', '2015-11-24 09:08:15.291', '管理员', '2015-11-24 09:08:15.291', '1', '20610', '67');
INSERT INTO "public"."sys_workgroup_user" VALUES ('20815', '管理员', '2015-11-24 09:08:15.295', '管理员', '2015-11-24 09:08:15.295', '1', '20610', '81');
INSERT INTO "public"."sys_workgroup_user" VALUES ('20816', '管理员', '2015-11-24 09:08:15.299', '管理员', '2015-11-24 09:08:15.299', '1', '20610', '91');
INSERT INTO "public"."sys_workgroup_user" VALUES ('20817', '管理员', '2015-11-24 09:10:10.86', '管理员', '2015-11-24 09:10:10.86', '1', '20613', '71');
INSERT INTO "public"."sys_workgroup_user" VALUES ('20818', '管理员', '2015-11-24 09:10:10.866', '管理员', '2015-11-24 09:10:10.866', '1', '20613', '68');
INSERT INTO "public"."sys_workgroup_user" VALUES ('20819', '管理员', '2015-11-24 09:10:10.869', '管理员', '2015-11-24 09:10:10.869', '1', '20613', '70');
INSERT INTO "public"."sys_workgroup_user" VALUES ('20820', '管理员', '2015-11-24 09:12:08.333', '管理员', '2015-11-24 09:12:08.333', '1', '20614', '97');
INSERT INTO "public"."sys_workgroup_user" VALUES ('20821', '管理员', '2015-11-24 09:16:02.032', '管理员', '2015-11-24 09:16:02.032', '1', '20615', '87');
INSERT INTO "public"."sys_workgroup_user" VALUES ('20822', '管理员', '2015-11-24 09:16:02.038', '管理员', '2015-11-24 09:16:02.038', '1', '20615', '88');
INSERT INTO "public"."sys_workgroup_user" VALUES ('20823', '管理员', '2015-11-24 09:38:33.414', '管理员', '2015-11-24 09:38:33.414', '1', '20616', '95');

-- ----------------------------
-- Alter Sequences Owned By 
-- ----------------------------
ALTER SEQUENCE "public"."act_evt_log_log_nr__seq" OWNED BY "act_evt_log"."log_nr_";

-- ----------------------------
-- Primary Key structure for table act_evt_log
-- ----------------------------
ALTER TABLE "public"."act_evt_log" ADD PRIMARY KEY ("log_nr_");

-- ----------------------------
-- Indexes structure for table act_ge_bytearray
-- ----------------------------
CREATE INDEX "act_idx_bytear_depl" ON "public"."act_ge_bytearray" USING btree (deployment_id_);

-- ----------------------------
-- Primary Key structure for table act_ge_bytearray
-- ----------------------------
ALTER TABLE "public"."act_ge_bytearray" ADD PRIMARY KEY ("id_");

-- ----------------------------
-- Primary Key structure for table act_ge_property
-- ----------------------------
ALTER TABLE "public"."act_ge_property" ADD PRIMARY KEY ("name_");

-- ----------------------------
-- Indexes structure for table act_hi_actinst
-- ----------------------------
CREATE INDEX "act_idx_hi_act_inst_end" ON "public"."act_hi_actinst" USING btree (end_time_);
CREATE INDEX "act_idx_hi_act_inst_exec" ON "public"."act_hi_actinst" USING btree (execution_id_, act_id_);
CREATE INDEX "act_idx_hi_act_inst_procinst" ON "public"."act_hi_actinst" USING btree (proc_inst_id_, act_id_);
CREATE INDEX "act_idx_hi_act_inst_start" ON "public"."act_hi_actinst" USING btree (start_time_);

-- ----------------------------
-- Primary Key structure for table act_hi_actinst
-- ----------------------------
ALTER TABLE "public"."act_hi_actinst" ADD PRIMARY KEY ("id_");

-- ----------------------------
-- Primary Key structure for table act_hi_attachment
-- ----------------------------
ALTER TABLE "public"."act_hi_attachment" ADD PRIMARY KEY ("id_");

-- ----------------------------
-- Primary Key structure for table act_hi_comment
-- ----------------------------
ALTER TABLE "public"."act_hi_comment" ADD PRIMARY KEY ("id_");

-- ----------------------------
-- Indexes structure for table act_hi_detail
-- ----------------------------
CREATE INDEX "act_idx_hi_detail_act_inst" ON "public"."act_hi_detail" USING btree (act_inst_id_);
CREATE INDEX "act_idx_hi_detail_name" ON "public"."act_hi_detail" USING btree (name_);
CREATE INDEX "act_idx_hi_detail_proc_inst" ON "public"."act_hi_detail" USING btree (proc_inst_id_);
CREATE INDEX "act_idx_hi_detail_task_id" ON "public"."act_hi_detail" USING btree (task_id_);
CREATE INDEX "act_idx_hi_detail_time" ON "public"."act_hi_detail" USING btree (time_);

-- ----------------------------
-- Primary Key structure for table act_hi_detail
-- ----------------------------
ALTER TABLE "public"."act_hi_detail" ADD PRIMARY KEY ("id_");

-- ----------------------------
-- Indexes structure for table act_hi_identitylink
-- ----------------------------
CREATE INDEX "act_idx_hi_ident_lnk_procinst" ON "public"."act_hi_identitylink" USING btree (proc_inst_id_);
CREATE INDEX "act_idx_hi_ident_lnk_task" ON "public"."act_hi_identitylink" USING btree (task_id_);
CREATE INDEX "act_idx_hi_ident_lnk_user" ON "public"."act_hi_identitylink" USING btree (user_id_);

-- ----------------------------
-- Primary Key structure for table act_hi_identitylink
-- ----------------------------
ALTER TABLE "public"."act_hi_identitylink" ADD PRIMARY KEY ("id_");

-- ----------------------------
-- Indexes structure for table act_hi_procinst
-- ----------------------------
CREATE INDEX "act_idx_hi_pro_i_buskey" ON "public"."act_hi_procinst" USING btree (business_key_);
CREATE INDEX "act_idx_hi_pro_inst_end" ON "public"."act_hi_procinst" USING btree (end_time_);

-- ----------------------------
-- Uniques structure for table act_hi_procinst
-- ----------------------------
ALTER TABLE "public"."act_hi_procinst" ADD UNIQUE ("proc_inst_id_");

-- ----------------------------
-- Primary Key structure for table act_hi_procinst
-- ----------------------------
ALTER TABLE "public"."act_hi_procinst" ADD PRIMARY KEY ("id_");

-- ----------------------------
-- Indexes structure for table act_hi_taskinst
-- ----------------------------
CREATE INDEX "act_idx_hi_task_inst_procinst" ON "public"."act_hi_taskinst" USING btree (proc_inst_id_);

-- ----------------------------
-- Primary Key structure for table act_hi_taskinst
-- ----------------------------
ALTER TABLE "public"."act_hi_taskinst" ADD PRIMARY KEY ("id_");

-- ----------------------------
-- Indexes structure for table act_hi_varinst
-- ----------------------------
CREATE INDEX "act_idx_hi_procvar_name_type" ON "public"."act_hi_varinst" USING btree (name_, var_type_);
CREATE INDEX "act_idx_hi_procvar_proc_inst" ON "public"."act_hi_varinst" USING btree (proc_inst_id_);
CREATE INDEX "act_idx_hi_procvar_task_id" ON "public"."act_hi_varinst" USING btree (task_id_);

-- ----------------------------
-- Primary Key structure for table act_hi_varinst
-- ----------------------------
ALTER TABLE "public"."act_hi_varinst" ADD PRIMARY KEY ("id_");

-- ----------------------------
-- Primary Key structure for table act_re_deployment
-- ----------------------------
ALTER TABLE "public"."act_re_deployment" ADD PRIMARY KEY ("id_");

-- ----------------------------
-- Indexes structure for table act_re_model
-- ----------------------------
CREATE INDEX "act_idx_model_deployment" ON "public"."act_re_model" USING btree (deployment_id_);
CREATE INDEX "act_idx_model_source" ON "public"."act_re_model" USING btree (editor_source_value_id_);
CREATE INDEX "act_idx_model_source_extra" ON "public"."act_re_model" USING btree (editor_source_extra_value_id_);

-- ----------------------------
-- Primary Key structure for table act_re_model
-- ----------------------------
ALTER TABLE "public"."act_re_model" ADD PRIMARY KEY ("id_");

-- ----------------------------
-- Uniques structure for table act_re_procdef
-- ----------------------------
ALTER TABLE "public"."act_re_procdef" ADD UNIQUE ("key_", "version_", "tenant_id_");

-- ----------------------------
-- Primary Key structure for table act_re_procdef
-- ----------------------------
ALTER TABLE "public"."act_re_procdef" ADD PRIMARY KEY ("id_");

-- ----------------------------
-- Indexes structure for table act_ru_event_subscr
-- ----------------------------
CREATE INDEX "act_idx_event_subscr" ON "public"."act_ru_event_subscr" USING btree (execution_id_);
CREATE INDEX "act_idx_event_subscr_config_" ON "public"."act_ru_event_subscr" USING btree (configuration_);

-- ----------------------------
-- Primary Key structure for table act_ru_event_subscr
-- ----------------------------
ALTER TABLE "public"."act_ru_event_subscr" ADD PRIMARY KEY ("id_");

-- ----------------------------
-- Indexes structure for table act_ru_execution
-- ----------------------------
CREATE INDEX "act_idx_exe_parent" ON "public"."act_ru_execution" USING btree (parent_id_);
CREATE INDEX "act_idx_exe_procdef" ON "public"."act_ru_execution" USING btree (proc_def_id_);
CREATE INDEX "act_idx_exe_procinst" ON "public"."act_ru_execution" USING btree (proc_inst_id_);
CREATE INDEX "act_idx_exe_super" ON "public"."act_ru_execution" USING btree (super_exec_);
CREATE INDEX "act_idx_exec_buskey" ON "public"."act_ru_execution" USING btree (business_key_);

-- ----------------------------
-- Primary Key structure for table act_ru_execution
-- ----------------------------
ALTER TABLE "public"."act_ru_execution" ADD PRIMARY KEY ("id_");

-- ----------------------------
-- Indexes structure for table act_ru_identitylink
-- ----------------------------
CREATE INDEX "act_idx_athrz_procedef" ON "public"."act_ru_identitylink" USING btree (proc_def_id_);
CREATE INDEX "act_idx_ident_lnk_group" ON "public"."act_ru_identitylink" USING btree (group_id_);
CREATE INDEX "act_idx_ident_lnk_user" ON "public"."act_ru_identitylink" USING btree (user_id_);
CREATE INDEX "act_idx_idl_procinst" ON "public"."act_ru_identitylink" USING btree (proc_inst_id_);
CREATE INDEX "act_idx_tskass_task" ON "public"."act_ru_identitylink" USING btree (task_id_);

-- ----------------------------
-- Primary Key structure for table act_ru_identitylink
-- ----------------------------
ALTER TABLE "public"."act_ru_identitylink" ADD PRIMARY KEY ("id_");

-- ----------------------------
-- Indexes structure for table act_ru_job
-- ----------------------------
CREATE INDEX "act_idx_job_exception" ON "public"."act_ru_job" USING btree (exception_stack_id_);

-- ----------------------------
-- Primary Key structure for table act_ru_job
-- ----------------------------
ALTER TABLE "public"."act_ru_job" ADD PRIMARY KEY ("id_");

-- ----------------------------
-- Indexes structure for table act_ru_task
-- ----------------------------
CREATE INDEX "act_idx_task_create" ON "public"."act_ru_task" USING btree (create_time_);
CREATE INDEX "act_idx_task_exec" ON "public"."act_ru_task" USING btree (execution_id_);
CREATE INDEX "act_idx_task_procdef" ON "public"."act_ru_task" USING btree (proc_def_id_);
CREATE INDEX "act_idx_task_procinst" ON "public"."act_ru_task" USING btree (proc_inst_id_);

-- ----------------------------
-- Primary Key structure for table act_ru_task
-- ----------------------------
ALTER TABLE "public"."act_ru_task" ADD PRIMARY KEY ("id_");

-- ----------------------------
-- Indexes structure for table act_ru_variable
-- ----------------------------
CREATE INDEX "act_idx_var_bytearray" ON "public"."act_ru_variable" USING btree (bytearray_id_);
CREATE INDEX "act_idx_var_exe" ON "public"."act_ru_variable" USING btree (execution_id_);
CREATE INDEX "act_idx_var_procinst" ON "public"."act_ru_variable" USING btree (proc_inst_id_);
CREATE INDEX "act_idx_variable_task_id" ON "public"."act_ru_variable" USING btree (task_id_);

-- ----------------------------
-- Primary Key structure for table act_ru_variable
-- ----------------------------
ALTER TABLE "public"."act_ru_variable" ADD PRIMARY KEY ("id_");

-- ----------------------------
-- Primary Key structure for table cm_contract
-- ----------------------------
ALTER TABLE "public"."cm_contract" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table couchdb_attach
-- ----------------------------
ALTER TABLE "public"."couchdb_attach" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table middleware_attachment
-- ----------------------------
ALTER TABLE "public"."middleware_attachment" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table openjpaseq
-- ----------------------------
ALTER TABLE "public"."openjpaseq" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table roffice_chance
-- ----------------------------
ALTER TABLE "public"."roffice_chance" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table roffice_contract
-- ----------------------------
ALTER TABLE "public"."roffice_contract" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table roffice_contract_detail
-- ----------------------------
ALTER TABLE "public"."roffice_contract_detail" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table roffice_deploy
-- ----------------------------
ALTER TABLE "public"."roffice_deploy" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table roffice_invoice
-- ----------------------------
ALTER TABLE "public"."roffice_invoice" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table roffice_news
-- ----------------------------
ALTER TABLE "public"."roffice_news" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table roffice_note
-- ----------------------------
ALTER TABLE "public"."roffice_note" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table roffice_pay
-- ----------------------------
ALTER TABLE "public"."roffice_pay" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table roffice_project
-- ----------------------------
ALTER TABLE "public"."roffice_project" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table roffice_projectwe
-- ----------------------------
ALTER TABLE "public"."roffice_projectwe" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table roffice_purchaseinvoice
-- ----------------------------
ALTER TABLE "public"."roffice_purchaseinvoice" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table roffice_receive
-- ----------------------------
ALTER TABLE "public"."roffice_receive" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table roffice_support
-- ----------------------------
ALTER TABLE "public"."roffice_support" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table roffice_task
-- ----------------------------
ALTER TABLE "public"."roffice_task" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table roffice_travel
-- ----------------------------
ALTER TABLE "public"."roffice_travel" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table sys_about
-- ----------------------------
ALTER TABLE "public"."sys_about" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table sys_application
-- ----------------------------
ALTER TABLE "public"."sys_application" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table sys_area
-- ----------------------------
ALTER TABLE "public"."sys_area" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table sys_audit
-- ----------------------------
ALTER TABLE "public"."sys_audit" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table sys_demo
-- ----------------------------
ALTER TABLE "public"."sys_demo" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table sys_department
-- ----------------------------
ALTER TABLE "public"."sys_department" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table sys_department_user
-- ----------------------------
ALTER TABLE "public"."sys_department_user" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table sys_dict
-- ----------------------------
ALTER TABLE "public"."sys_dict" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table sys_function
-- ----------------------------
ALTER TABLE "public"."sys_function" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table sys_hello
-- ----------------------------
ALTER TABLE "public"."sys_hello" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table sys_message
-- ----------------------------
ALTER TABLE "public"."sys_message" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table sys_news
-- ----------------------------
ALTER TABLE "public"."sys_news" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table sys_office
-- ----------------------------
ALTER TABLE "public"."sys_office" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table sys_organization
-- ----------------------------
ALTER TABLE "public"."sys_organization" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table sys_permission
-- ----------------------------
ALTER TABLE "public"."sys_permission" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table sys_role
-- ----------------------------
ALTER TABLE "public"."sys_role" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table sys_role_application
-- ----------------------------
ALTER TABLE "public"."sys_role_application" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table sys_role_function
-- ----------------------------
ALTER TABLE "public"."sys_role_function" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table sys_role_user
-- ----------------------------
ALTER TABLE "public"."sys_role_user" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table sys_user
-- ----------------------------
ALTER TABLE "public"."sys_user" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table sys_user_rel
-- ----------------------------
ALTER TABLE "public"."sys_user_rel" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Uniques structure for table sys_user_role
-- ----------------------------
ALTER TABLE "public"."sys_user_role" ADD UNIQUE ("user_id", "role_id");

-- ----------------------------
-- Primary Key structure for table sys_workgroup
-- ----------------------------
ALTER TABLE "public"."sys_workgroup" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table sys_workgroup_role
-- ----------------------------
ALTER TABLE "public"."sys_workgroup_role" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table sys_workgroup_user
-- ----------------------------
ALTER TABLE "public"."sys_workgroup_user" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Foreign Key structure for table "public"."act_ge_bytearray"
-- ----------------------------
ALTER TABLE "public"."act_ge_bytearray" ADD FOREIGN KEY ("deployment_id_") REFERENCES "public"."act_re_deployment" ("id_") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."act_re_model"
-- ----------------------------
ALTER TABLE "public"."act_re_model" ADD FOREIGN KEY ("deployment_id_") REFERENCES "public"."act_re_deployment" ("id_") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."act_re_model" ADD FOREIGN KEY ("editor_source_value_id_") REFERENCES "public"."act_ge_bytearray" ("id_") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."act_re_model" ADD FOREIGN KEY ("editor_source_extra_value_id_") REFERENCES "public"."act_ge_bytearray" ("id_") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."act_ru_event_subscr"
-- ----------------------------
ALTER TABLE "public"."act_ru_event_subscr" ADD FOREIGN KEY ("execution_id_") REFERENCES "public"."act_ru_execution" ("id_") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."act_ru_execution"
-- ----------------------------
ALTER TABLE "public"."act_ru_execution" ADD FOREIGN KEY ("proc_inst_id_") REFERENCES "public"."act_ru_execution" ("id_") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."act_ru_execution" ADD FOREIGN KEY ("parent_id_") REFERENCES "public"."act_ru_execution" ("id_") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."act_ru_execution" ADD FOREIGN KEY ("super_exec_") REFERENCES "public"."act_ru_execution" ("id_") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."act_ru_execution" ADD FOREIGN KEY ("proc_def_id_") REFERENCES "public"."act_re_procdef" ("id_") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."act_ru_identitylink"
-- ----------------------------
ALTER TABLE "public"."act_ru_identitylink" ADD FOREIGN KEY ("proc_def_id_") REFERENCES "public"."act_re_procdef" ("id_") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."act_ru_identitylink" ADD FOREIGN KEY ("proc_inst_id_") REFERENCES "public"."act_ru_execution" ("id_") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."act_ru_identitylink" ADD FOREIGN KEY ("task_id_") REFERENCES "public"."act_ru_task" ("id_") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."act_ru_job"
-- ----------------------------
ALTER TABLE "public"."act_ru_job" ADD FOREIGN KEY ("exception_stack_id_") REFERENCES "public"."act_ge_bytearray" ("id_") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."act_ru_task"
-- ----------------------------
ALTER TABLE "public"."act_ru_task" ADD FOREIGN KEY ("proc_inst_id_") REFERENCES "public"."act_ru_execution" ("id_") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."act_ru_task" ADD FOREIGN KEY ("execution_id_") REFERENCES "public"."act_ru_execution" ("id_") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."act_ru_task" ADD FOREIGN KEY ("proc_def_id_") REFERENCES "public"."act_re_procdef" ("id_") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."act_ru_variable"
-- ----------------------------
ALTER TABLE "public"."act_ru_variable" ADD FOREIGN KEY ("proc_inst_id_") REFERENCES "public"."act_ru_execution" ("id_") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."act_ru_variable" ADD FOREIGN KEY ("execution_id_") REFERENCES "public"."act_ru_execution" ("id_") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."act_ru_variable" ADD FOREIGN KEY ("bytearray_id_") REFERENCES "public"."act_ge_bytearray" ("id_") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."sys_office"
-- ----------------------------
ALTER TABLE "public"."sys_office" ADD FOREIGN KEY ("parent_id") REFERENCES "public"."sys_office" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."sys_permission"
-- ----------------------------
ALTER TABLE "public"."sys_permission" ADD FOREIGN KEY ("parent_id") REFERENCES "public"."sys_permission" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."sys_role_permission"
-- ----------------------------
ALTER TABLE "public"."sys_role_permission" ADD FOREIGN KEY ("permission_id") REFERENCES "public"."sys_permission" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."sys_role_permission" ADD FOREIGN KEY ("role_id") REFERENCES "public"."sys_role" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."sys_user_role"
-- ----------------------------
ALTER TABLE "public"."sys_user_role" ADD FOREIGN KEY ("role_id") REFERENCES "public"."sys_role" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."sys_user_role" ADD FOREIGN KEY ("user_id") REFERENCES "public"."sys_user" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
