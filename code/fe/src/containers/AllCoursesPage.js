import React from 'react';
import axios from 'axios'
import {Layout, Divider} from 'antd';
import Sidebar from '../components/Parts/Sidebar';
import Table from '../components/Parts/PaginationTable';
import Avatar from "../components/Parts/Avatar";
const {Header, Content, Sider}=Layout;
const columns = [{
    title: 'Id',
},{
    title: 'Name',
    type: 'link',
},{
    title: 'Time',
},{
    title: 'NumOfStudent',
},{
    title: 'Interval',
}];

/*const testdata = [{
    key: '1',
    id: '1',
    name: 'Math',
    time: '周二 08:00-10:00',
    total: 5,
    interval: 5,
},{
    key: '2',
    id: '2',
    name: 'English',
    time: '周二 08:00-10:00',
    total: 5,
    interval: 5,
}]*/


class AllcoursesPage extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            data:[]
        };
    }
    
    handleClick = (e) => {
      console.log('click', e);
    }

    componentDidMount = () => {
        /* for test 
        this.setState({
            data: testdata
        })*/
        axios.get('/api/course/byUser')
            .then((res) => {
                let data = res.data;
                if (data.length > 0) {
                    this.setState({
                        data: data
                    })
                }
            })
            .catch((error) => {
                console.log(error);
        });
    }
  
    render() {
      return (
        <Layout>
        <Header className={"header"} style={{background:'#aaa'}}>
            <Avatar/>
        </Header>
        <Layout>
          <Sider width={256} style={{background: '#fff'}}>
            <Sidebar />
          </Sider>
          <Layout>
            <Content>
               <Divider orientation="left"><h1>所有课程</h1></Divider>
               <Table column={columns} data={this.state.data} />
               <div className="fill"/>
            </Content>
          </Layout>
        </Layout>
        </Layout>
      );
    }
  }
  
export default AllcoursesPage;