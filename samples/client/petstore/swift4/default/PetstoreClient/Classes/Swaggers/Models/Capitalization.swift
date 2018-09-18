//
// Capitalization.swift
//
// Generated by swagger-codegen
// https://github.com/swagger-api/swagger-codegen
//

import Foundation



public struct Capitalization: Codable {

    public var smallCamel: String?
    public var capitalCamel: String?
    public var smallSnake: String?
    public var capitalSnake: String?
    public var sCAETHFlowPoints: String?
    /** Name of the pet  */
    public var ATT_NAME: String?

    public init(smallCamel: String?, capitalCamel: String?, smallSnake: String?, capitalSnake: String?, sCAETHFlowPoints: String?, ATT_NAME: String?) {
        self.smallCamel = smallCamel
        self.capitalCamel = capitalCamel
        self.smallSnake = smallSnake
        self.capitalSnake = capitalSnake
        self.sCAETHFlowPoints = sCAETHFlowPoints
        self.ATT_NAME = ATT_NAME
    }

    public enum CodingKeys: String, CodingKey { 
        case smallCamel
        case capitalCamel = "CapitalCamel"
        case smallSnake = "small_Snake"
        case capitalSnake = "Capital_Snake"
        case sCAETHFlowPoints = "SCA_ETH_Flow_Points"
        case ATT_NAME
    }


}

