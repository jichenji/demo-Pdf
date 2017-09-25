<!doctype html>
<html lang="zh-CN">
<head>
    <meta http-equiv=Content-Type content="text/html; charset=gb2312"/>
    <style type="text/css">
        body {
            min-width: initial;
            background: none repeat scroll 0 0 #fff;
            color: #000;
            min-height: 100%;
            min-width: 1080px;
        }
        .table1 {
            width:640px;
            border-collapse:collapse;
            border-top:1px;
            border-left:1px;
            font-size: 9.0px;
        }
        .table2 {
            width:1100px;
            font-size: 9.0px;
        }

        .td1 {
            width:80px;
            height:25px;
            border-right:1px;
            border-bottom:1px;
        }
        .td2 {
            width:80px;
            height:16px;
            border-right:1px;
            border-bottom:1px;
        }
        .td3 {
            width:300px;
            height:70px;
            font-size: 9.0px;
        }
        .td4 {
            width:200px;
            height:70px;
            font-size: 9.0px;
        }
        h1 {
            margin-bottom: 0cm;
            line-height: 150%;
            font-size: 9.0px;
        }

        .p {
            margin-top: 0cm;
            margin-bottom: 0cm;
            line-height: 150%;
            font-size: 9.0px;
        }
        .name{
            font-size: 9.0px;
        }
    </style>
</head>

<body>


<p align=center style='font-size:14.0pt;font-weight:bold' >借款协议</p>

<p style='font-size:9.0pt;'>借款协议编号：${listingId!''}</p>

<p style='font-size:9.0pt;'>借出人：拍拍贷网站实名用户</p>

<p style='font-size:9.0pt;'>借款人：${userName!''}</p>

<p style='font-size:9.0pt;'>居间人：上海拍拍贷金融信息服务有限公司</p>

<p style='font-size:9.0pt;'>日期：${listingStartTime!''}</p>

<p  class="p">&nbsp;</p>

<p style='font-size:9.0pt;'>说明： </p>

<p class="p">1、&nbsp;居间人是一家合法成立并有效存续的有限责任公司，拥有www.ppdai.com网站及/或客户端（以下称“拍拍贷网站”或“拍拍贷平台”）的经营权，并为各主体提供信息交互、撮合、资信评估等居间服务。</p>

<p class="p">2、&nbsp;借出人将自有合法资金通过拍拍贷平台自愿出借，借款人通过拍拍贷平台寻求借款；双方均接受居间人提供的居间服务而达成借款合意。</p>

<p class="p">3、&nbsp;本协议采用电子合同形式，借出人和借款人在操作之前均需仔细阅读并确认同意本协议各条款， 且本协议模板已由居间人在拍拍贷网站公布。</p>

<p class="p">&nbsp;</p>
<h1>一、定义</h1>

<p class="p">1、&nbsp;服务费：因居间人提供信息交互、撮合、资信评估等居间服务而向借款人和/或借出人收取的费用。</p>

<p class="p">2、&nbsp;应付款项：指借款人需要向出借人偿还的全部款项（“应还款项”）以及需要向拍拍贷支付的费用的合称，包括但不限于本金、利息、逾期利息、列表手续费、列表创建费、质保专款、分期手续费、催收费用、提前还款管理费等，以及借出人或居间人为实现债权而发生的其他费用。</p>

<p class="p">3、&nbsp;催收费用：指借款人逾期还款的情况下，居间人对逾期款项进行催收和追讨而产生的费用。</p>

<p  class="p">&nbsp;</p>
<h1>二、借款的基本条款</h1>
<p class="p">&nbsp;</p>
<#if listingPolicyDetails??>
<table class="table1">
    <thead>
    <tr>
        <td class="td1">借出人(用户名)
        </td>
        <td class="td1">借款金额
        </td>
        <td class="td1">借款期限
        </td>
        <td class="td1">年利率(单利)
        </td>
        <td class="td1">借款开始日
        </td>
        <td class="td1">借款到期日
        </td>
        <td class="td1">月还款日
        </td>
        <td class="td1">月还款本息额</td>
    </tr>
    </thead>
    <tbody>
        <#list listingPolicyDetails as item>
        <tr>
            <td class="td2">${item.userName!''}
            </td>
            <td class="td2">${item.bidAmount!''}
            </td>
            <td class="td2">${item.listingMonth!''}个月
            </td>
            <td class="td2">${item.listingCurrentRate!''}
            </td>
            <td class="td2">${item.listingStartDate!''}
            </td>
            <td class="td2">${item.listingEndDate!''}
            </td>
            <#if repaymentType != 3>
                <#if repaymentType== 0||repaymentType==2>
                    <td class="td2"> 每个月${item.monthRepaymentDay!''}日</td>
                <#else>
                    <td class="td2"> ${item.monthRepaymentDay!''}</td>
                </#if>
            </#if>
            <td class="td2">${item.monthRepaymentMoney!''}</td>
        </tr>
        </#list>
    <tr>

        <td class="td2">总计：
        </td>
        <td class="td2">${amount!''}
        </td>
        <td class="td2"></td>
        <td class="td2"></td>
        <td class="td2"></td>
        <td class="td2"></td>
        <td class="td2"></td>
        <td class="td2">${monthlyPayment!''}</td>
    </tr>
    </tbody>
</table>
</#if >

<p class="p">&nbsp;</p>
<h1>三、借款发放及还款</h1>

<p class="p">1、&nbsp;借出人和借款人在拍拍贷平台完成资金匹配且通过居间人审核时，本协议成立；通过审核后,居间人将出借款划转、支付至借款人开设在居间人平台的账户（下称“拍拍贷账户”），或借款人指定的收款账户，居间人完成以上操作后，本协议生效。</p>

<p class="p">2、&nbsp;借款人承诺按照本协议第二条约定的时间和金额按期足额向借出人还款。借款人的最后一期还款时必须包含全部应付款项。</p>

<p class="p">3、&nbsp;借出人同意由居间人代其进行发放借款的操作和代为收取借款人偿还的应还款项，并同意居间人按本协议及拍拍贷网站有关规则对出借款项和相关费用进行划扣和支付。借款人同意居间人将应还款项按照借出人的出借金额比例划付至借出人账户，质保专款（如有）按照《质量保障服务协议》的要求进行划付，完成本协议项下部分或全部还款。</p>

<p class="p">4、&nbsp;若借款人的任何一期还款不足以偿还应还全部本金、利息、逾期利息和其他应付款项的，借出人同意按照出借金额的相应比例收取还款。</p>

<p class="p">5、&nbsp;应付款项分配顺序：借款人支付的应付款项均应按照如下顺序进行分配：</p>

<p class="p">（1）&nbsp;&nbsp;居间人以外的第三方收取的追索债权相关费用（如有）；</p>

<p class="p">（2）&nbsp;&nbsp;借款本金；</p>

<p class="p">（3）&nbsp;&nbsp;借款利息；</p>

<p class="p">（4）&nbsp;&nbsp;逾期利息；</p>

<p class="p">（5）&nbsp;&nbsp;催收费用；</p>

<p class="p">（6）&nbsp;&nbsp;列表手续费、列表创建费、质保专款、分期手续费；</p>

<p class="p">（7）&nbsp;&nbsp;根据本协议产生的其他全部费用。</p>

<p class="p">&nbsp;</p>
<h1>四、提前还款</h1>

<p class="p">
    1、&nbsp;除适用特殊规则的借款标的外，借款人有权一次性提前偿还全部借款并结清利息，提前一次性偿还全部借款按本协议约定的利率和借款实际使用天数收取利息，并提前一次性支付分期手续费及质保专款未付部分。</p>

<p class="p">2、&nbsp;借款人提前偿还部分借款的，仍应按本协议约定的月还款本息额向借出人支付本金和利息。 </p>

<p class="p">&nbsp;</p>
<h1>五、逾期还款</h1>

<p class="p">1、&nbsp;借款人和借出人一致同意：借款逾期后，借出人委托居间人对逾期款项进行还款提醒和催收。还款提醒和催收方式包括但不限于：给借款人和/或借款人的联系人发送短信、发送电子邮件、电话、上门及委托第三方。</p>
<p class="p">2、&nbsp;若借款人逾期还款，则借款人除了向借出人按照以下标准支付逾期利息之外，还应当向居间人以及居间人委托的第三方支付催收费用。</p>
<p class="p">&nbsp;</p>
<p class="p">&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;借款期限大于6个月，按年化利率24%收取逾期利息；</p>
<p class="p">&nbsp;</p>
<p class="p">&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;借款期限小于等于6个月，按年化利率22.4%收取逾期利息。</p>
<p class="p">3、&nbsp;借款人借款逾期后，居间人有权将借款人提供的以及居间人通过本协议或其他合法渠道获得的个人信息披露给借出人，并在法律允许的范围内将其列入网站黑名单，及国家和地方的个人征信系统，同时有权将借款人提交的或居间人通过本协议或其他合法渠道自行收集的借款人的个人资料和信息与第三方进行数据共享，用于借出人、居间人和第三方催收逾期借款并用于对借款人其他申请的审核，一切法律责任由借款人承担，与居间人无涉。</p>

<p class="p">4、&nbsp;各方一致同意，如居间人根据《质量保障服务协议》向相关借款人提取并代为保管的的质保专款补偿了借款人的应还款项，借出人同意并认可上述补偿行为并不代表前述资金损失应归责于居间人亦不代表居间人须为此承担担保或其他任何责任。</p>

<p class="p">5、&nbsp;在借款人逾期还款的情况下，借出人授权居间人采取包括但不限于如下方式对债权进行追索：委托专业的催收公司或自行催收、将债权转让给第三方。居间人有权决定与以上债权追索相关的事宜，包括选定委托催收公司和决定催收费用、按照市场公允价格合理确定债权转让价格等。</p>

<p class="p">6、&nbsp;借出人一致同意，经追索实现的债权款项应当全额支付至居间人指定的账户，并在扣除为实现债权支付的相关费用（包括但不限于第三方催收费用、差旅费用和公证费用）后，由居间人负责向借出人进行支付。如经追索实现的债权不足以偿还本协议项下约定的本金、利息、逾期利息等的，在扣除为实现债权支付的相关费用后，借出人同意各自按照其借出款项比例收取本金、利息及逾期利息。</p>

<p class="p">7、&nbsp;若借款人逾期还款超过90个自然日，或借出人/居间人发现借款人出现逃避、拒绝沟通或拒绝承认欠款事实、故意转让资金、信用情况恶化等危害本协议借款偿还的情形，则借出人有权要求并有权委托居间人要求借款人一次性提前偿还全部借款。</p>

<p class="p">&nbsp;</p>
<h1>六、特殊逾期还款条款</h1>

<p class="p">1、&nbsp;出于保护借出人利益，以及便于居间人协助追索债权的目的，如借款人逾期还款超过90个自然日，或借款人在逾期后出现逃避、拒绝沟通或拒绝承认欠款事实等恶意行为的，全体借出人一致同意将本协议项下追偿权无偿转让给居间人，由居间人统一向借款人追索。借出人一致同意，经追索实现的债权款项应当全额支付至居间人指定的账户，并在扣除为实现债权支付的相关费用（包括催收费用、诉讼保全费用，律师费用及诉讼费用等）后，由居间人负责向借出人进行支付。如经追索实现的债权不足以偿还本协议项下约定的本金、利息、逾期利息等的，在扣除为实现债权支付的相关费用后，借出人同意各自按照其借出款项比例收取本金、利息及逾期利息。</p>

<p class="p">2、&nbsp;借出人同意，出于最大程度保障借出人利益角度出发，基于居间人的专业判断，居间人可根据借款人实际情况，居间人有权将以上无偿取得的追偿权转让给第三方，转让价格由居间人决定。转让后的债权款项在扣除债权转让相关费用后，由居间人负责向借出人进行支付。如转让所得债权款项在扣除债权转让相关费用后，不足以偿还本协议项下约定的本金、利息、逾期利息等的，借出人同意各自按照其借出款项比例收取本金、利息及逾期利息。</p>

<p class="p">3、&nbsp;借出人同意，在居间人采取诉讼方式追索债权时，在追索无果的情况下，在诉讼执行程序完结后，借款人尚未偿还的借款本金、利息和逾期利息对应的追偿权自动无偿转让给借出人，由借出人自行向借款人追索。</p>

<p class="p">4、&nbsp;如该借款标的符合适用质量保障服务范围的，则适用质量保障服务协议的约定。</p>

<p class="p">&nbsp;</p>
<h1>七、债权转让</h1>

<p class="p">1、&nbsp;借出人有权将本协议项下对借款人享有的部分或全部债权对外转让，且转让次数不受限制。</p>

<p class="p">2、&nbsp;通知：借出人授权居间人以以下任意一种方式对借款人进行债权转让通知：</p>

<p class="p">（1）&nbsp;&nbsp;向借款人预留的电子邮箱发送电子邮件；向借款人预留的手机号码发送短信；向借款人发送站内信等。借款人同意该债权转让自居间人通知发出之日起对借款人发生效力。</p>

<p class="p">（2）&nbsp;&nbsp;对于投标及信息服务项下的项目或计划涉及的债权转让，居间人将会实时更新投资该借款标的的借出人具体信息，借款人确认居间人对该标的的借出人实时更新的行为视为债权转让通知，且该债权转让在借出人信息实时更新后对借款人发生效力。</p>

<p class="p">（3）&nbsp;&nbsp;其他拍拍贷网站规则或公告规定的通知方式。</p>

<p class="p">3、&nbsp;借出人债权转让后，借款人应按照本协议的约定向债权受让人支付每期应还款项；受让人受让借款人在本协议项下之各项权利、义务并受本协议项下及拍拍贷平台规则的约束。</p>

<p class="p">&nbsp;</p>
<h1>八、各方权利和义务</h1>

<p class="p">（一）借出人权利和义务</p>

<p class="p">1、&nbsp;借出人享有其所出借款项所带来的利息收益，并应自行缴纳由利息所得带来的可能的税费。</p>

<p class="p">2、&nbsp;如借款人违约，居间人可以向借出人提供其已获得的借款人信息。</p>

<p class="p">3、&nbsp;借出人承诺其了解融资项目信贷风险，确认具有相应的风险认知和承受能力，并自行承担借贷产生的本息损失。</p>

<p class="p">（二）借款人权利和义务</p>

<p class="p">
    1、&nbsp;借款人应确保自身具有与借款金额相匹配的还款能力，且必须按照本协议的约定按期足额向借出人归还每期本金、利息及逾期利息，向居间人支付借款相关费用，并支付逾期及提前还款情况下产生的其他有关费用。</p>

<p class="p">2、&nbsp;借款人同意，为履行本协议项下义务，居间人可以使用其自行收集或借款人自行提供的资料和信息用于包括但不限于以下用途：</p>

<p class="p">（1）&nbsp;居间人或居间人指定的第三方对其进行信用等级评估或验证其信息；</p>

<p class="p">（2）&nbsp;向居间人的合作机构披露；</p>

<p class="p">（3）&nbsp;若借款人逾期还款，借款人个人信息及违约的相关信息将录入拍拍贷网站黑名单并向第三方披露；</p>

<p class="p">（4）&nbsp;用于解决纠纷等。</p>

<p class="p">3、&nbsp;借款人不得将本协议项下的任何权利义务转让给任何第三方。</p>

<p class="p">4、&nbsp;借款人知悉并同意，在其逾期还款的情况下，居间人有权通过电话、短信或其他方式联络其联系人，并将借款人逾期还款的相关情况告知该等联系人。</p>

<p class="p">5、&nbsp;借款人在提交借款申请时应提供其在所有网络借贷信息中介机构未偿还借款信息，并对所有影响或可能影响借出人权益的重大信息向借出人和居间人如实报告。</p>

<p class="p">6、&nbsp;借款人不得从事以下行为：</p>

<p class="p">（1）&nbsp;通过故意变换身份、虚构融资项目、夸大融资项目收益前景等形式的欺诈借款；</p>

<p class="p">（2）&nbsp;同时通过多个网络借贷信息中介机构，或者通过变换项目名称、对项目内容进行非实质性变更等方式，就同一融资项目进行重复融资；</p>

<p class="p">（3）&nbsp;在网络借贷信息中介机构以外的公开场所发布同一融资项目的信息；</p>

<p class="p">（4）&nbsp;法律法规和网络借贷有关监管规定禁止从事的其他活动。</p>

<p class="p">（三）居间人权利和义务</p>

<p class="p">1、&nbsp;居间人有权评定借款人的个人信用等级，并根据对借款人个人信息的评审结果，决定是否对其借款申请予以核准。</p>

<p class="p">2、&nbsp;居间人有权对对借出人的年龄、财务状况、投资经验、风险偏好、风险承受能力等进行尽职评估，并根据风险评估结果对借出人实行分级管理，设置可动态调整的出借限额和出借标的限制。</p>

<p class="p">3、&nbsp;借款成功后，居间人将该笔借款在扣除居间人应收取的相关费用后直接划付至借款人拍拍贷账户或借款人指定的其他账户，并将借款人当期应还款项划付至各借出人的拍拍贷账户。</p>

<p class="p">4、&nbsp;借出人和借款人知悉并同意，居间人有权按照法律法规及其他监管要求对包括但不限于借款等信息进行披露或展示。</p>

<p class="p">5、&nbsp;居间人既不是借贷关系主体，也不是该借贷关系中的担保方。</p>

<p class="p">&nbsp;</p>
<h1>九、费用</h1>

<p class="p"> 1、&nbsp;居间人因提供本协议项下约定服务，有权向借款人收取包括但不限于以下费用：列表手续费、列表创建费、质保专款、分期手续费、提前还款管理费、催收费用，具体收费标准如下：</p>
<p class="p">（1）&nbsp;&nbsp;列表手续费每月为<u>
<#if feePeriodNum==months>
${poundagePerMonth!''}
<#else>
    &nbsp;&nbsp;&nbsp;&nbsp;
</#if>
</u>元/一次性收取<u>
<#if feePeriodNum==0>
${poundage!''}
<#else>
    &nbsp;&nbsp;&nbsp;&nbsp;
</#if>
</u>元/总额为<u>
<#if feePeriodNum!=months&& feePeriodNum!=0>
${totalPoundage!''}
<#else>
    &nbsp;&nbsp;&nbsp;&nbsp;
</#if>
</u>元，前<u>
<#if feePeriodNum!=months&& feePeriodNum!=0>
${feePeriodNum!''}
<#else>
    &nbsp;&nbsp;&nbsp;&nbsp;
</#if>
</u>期平均每期收取<u>
<#if feePeriodNum!=months&& feePeriodNum!=0>
${poundagePerMonth!''}
<#else>
    &nbsp;&nbsp;&nbsp;&nbsp;
</#if>
</u>元；列表创建费收取<u>0</u>元（如有）；</p>
<p class="p">（2）&nbsp;&nbsp;质保专款每月为<u>${valueAddedFeePerMonth!''}</u>元/一次性收取<u>${valueAddedFee!''}</u>元；</p>
<p class="p">（3）&nbsp;&nbsp;分期手续费每月为<u>0</u>元/一次性收取<u>0.00</u>元（如有）；</p>
<p class="p">（4）&nbsp;&nbsp;提前还款的管理费为尚未偿还本金的<u>0</u>%；</p>
<p class="p">（5）&nbsp;&nbsp;催收费用为当日逾期本金的千分之六，当期催收费用最低为人民币<u>10.00</u>元；</p>
<p class="p">（6）&nbsp;&nbsp;其他：<u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</u>。
</p>
<p class="p"> 2、&nbsp;以上费用可由居间人从借款人拍拍贷账户或其他账户直接扣除。</p>

<p class="p">&nbsp;</p>
<h1>十、违约责任</h1>

<p class="p">1、&nbsp;本协议提前解除时，若借款人在拍拍贷网站的账户里有任何资金余款，居间人有权将借款人的余款用于清偿，并要求借款人支付因此产生的相关费用。</p>

<p class="p">2、&nbsp;本借款协议中，所有借出人与借款人之间的借款均是相互独立的。若借款人违约，借出人中的任何一方均有权单独向借款人追索或者提起诉讼。</p>

<p class="p">&nbsp;</p>
<h1>十一、承诺与保证</h1>

<p class="p">1、&nbsp;借出人和借款人保证其是具有完全民事行为能力的中华人民共和国公民，且其向居间人提供的信息、资料均为合法、真实、有效，不存在任何虚假、遗漏和隐瞒。</p>

<p class="p">2、&nbsp;自本协议成立之日起至应付款项全部清偿前，借出人或借款人的下列信息如发生变更的，其应当在相关信息发生变更三日内将更新后的信息提供给居间人，变更信息包括但不限于本人、本人的家庭联系人及紧急联系人、工作单位、居住地址、住所电话、手机号码、电子邮箱、银行账户信息。若因任何一方不及时提供上述变更信息而带来的损失或额外费用应由该方自行承担。</p>

<p class="p">3、&nbsp;借出人承诺出借资金来源合法且是该资金的合法所有人。
    如果第三方对资金的归属、合法性问题发生争议，由借出人自行负责解决。因借出人出借资金来源不合法导致对借款人和居间人造成损失的，由借出人承担全部责任。在该等争议解决之前，居间人有权根据行政机关、司法机关或仲裁机构出具的生效法律文书或在确凿证据支持下，以合理的判断拒绝向借出人和借款人支付居间人代其划扣的相关款项。</p>

<p class="p">4、&nbsp;借款人不得将借款用于任何违法活动（包括但不限于赌博、吸毒、贩毒、卖淫嫖娼等），否则，借出人或居间人将立即向公安或其他有关部门举报，并追究借款人的刑事责任。</p>

<p class="p">5、&nbsp;借款人不得将借款用于生产经营和消费以外的范畴（包括但不限于投资股票、场外配资、期货合约、结构化产品及其他衍生品等高风险领域等），不得将所借款项用于出借等其他目的。</p>

<p class="p">&nbsp;</p>
<h1>十二、法律适用和管辖</h1>

<p class="p">1、&nbsp;本协议签订地为上海市浦东新区。</p>

<p class="p">2、&nbsp;本协议的签订、履行、终止、解释等而产生的纠纷均由以上各方协商解决，如协商无法解决，则任何一方可向本协议签订地有管辖权的人民法院起诉。</p>

<p class="p">&nbsp;</p>
<h1>十三、其他</h1>

<p class="p">1、&nbsp;本协议或本协议的补充协议均在拍拍贷网站以电子合同形式体现，形成并存在一份或多份，每一份具有同等法律效力；并均保存在居间人的专用服务器上备查和保管，各方均认可电子合同的法律效力。各方同意，如各方有争议的，则以居间人所保留文档版本以及居间人解释为准。</p>

<p class="p">2、&nbsp;在借款人将本协议项下的应付款项全部偿还或支付完毕后，本协议自动终止。</p>

<p class="p">3、&nbsp;如果本协议中的任何条款违反相关的法律法规，则该条将被视为无效；但该无效条款并不影响本协议其他条款的效力。</p>

<p class="p">&nbsp;</p>
<p class="p">&nbsp;</p>
<p class="p" style="color: white;margin-left:50pt;">${userName}_签章</p>

<p class="p">&nbsp;</p>
<p class="p">&nbsp;</p>
<p class="p">&nbsp;</p>
<p class="p">&nbsp;</p>
<p class="p">&nbsp;</p>
<p class="p">&nbsp;</p>
<p class="p">&nbsp;</p>
<p class="p">&nbsp;</p>
<p class="p" style="color: white;margin-left:50pt;">上海拍拍贷金融信息服务有限公司_签章</p>

<p class="p">&nbsp;</p>
<p class="p">&nbsp;</p>
<p class="p">&nbsp;</p>
<p class="p">&nbsp;</p>
<p class="p">&nbsp;</p>
<p class="p">&nbsp;</p>
<p class="p">&nbsp;</p>
<p class="p">&nbsp;</p>


<table class="table2" style="color: white;">
<#list listingPolicyDetails as item>
    <#if item_index%4==0>
    <tr>
        <td class="td4"></td>
    </#if>
    <td class="td3">${item.userName!''}_签章</td>
    <#if item_index%4==3>
    </tr>
    </#if>
</#list>
<#if (listingPolicyDetails?size)%4!=0>
    </tr>
</#if>
</table>

</body>

</html>
