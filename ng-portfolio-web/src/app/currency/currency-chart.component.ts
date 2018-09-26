import {Component, OnInit} from '@angular/core';
import * as d3 from 'd3';

@Component({
  selector: 'bs-currency-chart',
  templateUrl: './currency-chart.component.html',
  styleUrls: ['./currency-chart.component.css']
})
export class CurrencyChartComponent implements OnInit {

  exchanges: any[] = [
    {date: '01/01/2018', value: 2}, {date: '02/01/2018', value: 3}, {date: '03/01/2018', value: 1},
    {date: '04/01/2018', value: 4}, {date: '05/01/2018', value: 5}, {date: '06/01/2018', value: 3}
  ];

  constructor() {
  }

  ngOnInit() {

    const margin = {top: 20, right: 20, bottom: 30, left: 50},
      width = 400 - margin.left - margin.right,
      height = 400 - margin.top - margin.bottom;

    const parseTime = d3.timeParse("%d/%m/%Y");

    const x = d3.scaleTime().range([0, width]);
    const y = d3.scaleLinear().range([height, 0]);

    const valueline = d3.line()
      .x(function (d: any) {
        return x(d.dateValue);
      })
      .y(function (d: any) {
        return y(d.value);
      });

    const svg = d3.select("#chart")
      .attr("width", width + margin.left + margin.right)
      .attr("height", height + margin.top + margin.bottom)
      .append("g")
      .attr("transform",
        "translate(" + margin.left + "," + margin.top + ")");

    this.exchanges.forEach(function (d) {
      d.dateValue = parseTime(d.date);
    });

    x.domain(d3.extent(this.exchanges, function (d) {
      return d.dateValue;
    }));
    y.domain([0, d3.max(this.exchanges, function (d) {
      return d.value;
    })]);

    svg.append("path")
      .data([this.exchanges])
      .attr("class", "line")
      .style("fill", "none")
      .style("stroke", "steelblue")
      .style("stroke-width", "2px")
      .attr("d", valueline);

    svg.append("g")
      .attr("transform", "translate(0," + height + ")")
      .call(d3.axisBottom(x));

    svg.append("g")
      .call(d3.axisLeft(y));

  }
}
